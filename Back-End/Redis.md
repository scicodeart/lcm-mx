# REDIS

## 开篇

* Redis 是互联网技术领域使用最为广泛的存储中间件 Remote Dictionary Service

### Redis可以做什么

因为在请求压力不大的情况下，很多数据都是可以直接从数据库中查询的。但请求压力一大，以前通过数据库直接存取的数据则必须要挪到缓存里来。

### 插播：Redis面试题

* Redis的存储有哪些数据结构？

```java
字符串String、字典Hash、列表List、集合Set、有序集合SortedSet。

如果你是Redis中高级用户，还需要加上下面几种数据结构HyperLogLog、Geo、Pub/Sub。

如果你说还玩过Redis Module，像BloomFilter，RedisSearch，Redis-ML，面试官得眼睛就开始发亮了。
```

* 使用过Redis分布式锁么，它是什么回事？

```java
先拿setnx来争抢锁，抢到之后，再用expire给锁加一个过期时间防止锁忘记了释放。

这时候对方会告诉你说你回答得不错，然后接着问如果在setnx之后执行expire之前进程意外crash或者要重启维护了，那会怎么样？

然后回答：我记得set指令有非常复杂的参数，这个应该是可以同时把setnx和expire合成一条指令来用的！对方这时会显露笑容，心里开始默念：摁，这小子还不错。
```

* 假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如果将它们全部找出来？

```java
使用keys指令可以扫出指定模式的key列表。

redis 127.0.0.1:6379> KEYS *
1) "runoob3"
2) "runoob1"
3) "runoob2"
```

* 如果这个redis正在给线上的业务提供服务，那使用keys指令会有什么问题？

```java
这个时候你要回答redis关键的一个特性：redis的单线程的。keys指令会导致线程阻塞一段时间，线上服务会停顿，直到指令执行完毕，服务才能恢复。
这个时候可以使用scan指令，scan指令可以无阻塞的提取出指定模式的key列表，但是会有一定的重复概率，在客户端做一次去重就可以了，但是整体所花费的时间会比直接用keys指令长。
```

* 使用过Redis做异步队列么，你是怎么用的？

```java

```

* 如果对方追问pub/sub有什么缺点？

* Redis如何做持久化的？

* Pipeline有什么好处，为什么要用pipeline？
* 为什么 Redis 的默认端口是 6379?

```java
我们都知道 Redis 的默认端口是 6379，这个端口号也不 是随机选的，而是由手机键盘字母「MERZ」 的位置决定的。
```

## 基础

### Redis 基础数据结构

Redis 有 5 种基础数据结构，分别为:string (字符串)、list (列表)、set (集合)、hash (哈希) 和 zset (有序集合)。

#### 1.string

##### 定义：

Redis 所有的数据结构都是以唯一的 key字符串作为名称，然后通过这个唯一 key 值来获取相应的 value 数据。不同类型的数据结构的差异就在于 value 的结构不一样。

##### 应用：

字符串结构使用非常广泛，一个常见的用途就是缓存用户信息。我们将用户信息结构体使用 JSON 序列化成字符串，然后将序列化后的字符串塞进 Redis 来缓存。同样，取用户信息会经过一次反序列化的过程。

##### 内部：

Redis 的字符串是动态字符串，是可以修改的字符串，内部结构实现上类似于 Java 的ArrayList，采用预分配冗余空间的方式来减少内存的频繁分配，如图中所示，内部为当前字符串实际分配的空间 capacity 一般要高于实际字符串长度 len。当字符串长度小于 1M 时，扩容都是加倍现有的空间，如果超过 1M，扩容时一次只会多扩 1M 的空间。需要注意的是字符串最大长度为512M。

##### 实践:

* 键值对

```java
    > set name codehole
    OK
    > get name
    "codehole"
    > exists name
    (integer) 1
    > del name
    (integer) 1
    > get name
    (nil)
```

* 批量键值对

```java
		可以批量对多个字符串进行读写，节省网络耗时开销。
    > set name1 codehole
    OK
    > set name2 holycoder
    OK
    > mget name1 name2 name3 # 返回一个列表 1) "codehole"
    2) "holycoder"
    3) (nil)
    > mset name1 boy name2 girl name3 unknown > mget name1 name2 name3
    1) "boy"
    2) "girl"
    3) "unknown"
```

* 过期和 set 命令扩展
* 计数

```java
如果 value 值是一个整数，还可以对它进行自增操作。自增是有范围的，它的范围是 signed long 的最大最小值，超过了这个值，Redis 会报错。

		> set age 30
    OK
    > incr age
    (integer) 31
    > incrby age 5
    (integer) 36
    > incrby age -5
    (integer) 31
		> set codehole 9223372036854775807
		# Long.Max
    OK
    > incr codehole
```

#### 2.list (列表)

##### 数据结构：

结构：Redis 的列表相当于 Java 语言里面的 LinkedList，注意它是链表而不是数组。

时间复杂度：这意味着list 的插入和删除操作非常快，时间复杂度为 O(1)，但是索引定位很慢，时间复杂度O(n)，这点让人非常意外。

回收机制：当列表弹出了最后一个元素之后，该数据结构自动被删除，内存被回收。

Redis 的列表结构常用来做异步队列使用。将需要延后处理的任务结构体序列化成字符串塞进 Redis 的列表，另一个线程从这个列表中轮询数据进行处理。

##### 实践：

* 右边进左边出:队列

```JAVA
> rpush books python java golang (integer) 3
> llen books
(integer) 3
    > lpop books
    "python"
    > lpop books
    "java"
    > lpop books
    "golang"
    > lpop books
    (nil)
```

* 右边进右边出:栈

```java
> rpush books python java golang (integer) 3
> rpop books
"golang"
    > rpop books
    "java"
    > rpop books
    "python"
> rpop books
```

* 慢操作

lindex 相当于 Java 链表的 get(int index)方法，它需要对链表进行遍历，性能随着参数 index 增大而变差。 ltrim 和字面上的含义不太一样，个人觉得它叫 lretain(保留) 更合适一 些，因为 ltrim 跟的两个参数 start_index 和 end_index 定义了一个区间，在这个区间内的值， ltrim 要保留，区间之外统统砍掉。我们可以通过 ltrim 来实现一个定长的链表，这一点非常 有用。index 可以为负数，index=-1 表示倒数第一个元素，同样 index=-2 表示倒数第二个元 素。 

```java
> rpush books python java golang (integer) 3
> lindex books 1 # O(n) 慎用 "java"
> lrange books 0 -1 # 获取所有元素，O(n) 慎用 
1) "python"
2) "java"
3) "golang"
> ltrim books 1 -1 # O(n) 慎用 OK
> lrange books 0 -1
1) "java"
2) "golang"
> ltrim books 1 0 # 这其实是清空了整个列表，因为区间范围长度为负 OK
> llen books
(integer) 0
```

* 快速列表

如果再深入一点，你会发现 Redis 底层存储的还不是一个简单的 linkedlist，而是称之为快速链表 quicklist 的一个结构。

首先在列表元素较少的情况下会使用一块连续的内存存储，这个结构是 ziplist，也即是压缩列表。它将所有的元素紧挨着一起存储，分配的是一块连续的内存。当数据量比较多的时候才会改成 quicklist。因为普通的链表需要的附加指针空间太大，会比较浪费空间，而且会加重内存的碎片化。比如这个列表里存的只是 int 类型的数据，结构上还需要两个额外的指针 prev 和 next 。所以 Redis 将链表和 ziplist 结合起来组成了 quicklist。也就是将多个ziplist 使用双向指针串起来使用。这样既满足了快速的插入删除性能，又不会出现太大的空间冗余。

#### 3.hash (字典)

Redis 的字典相当于 Java 语言里面的 HashMap，它是无序字典。内部实现结构上同Java 的 HashMap 也是一致的，同样的数组 + 链表二维结构。第一维 hash 的数组位置碰撞时，就会将碰撞的元素使用链表串接起来。

Redis 的字典相当于 Java 语言里面的 HashMap，它是无序字典。内部实现结构上同Java 的 HashMap 也是一致的，同样的数组 + 链表二维结构。第一维 hash 的数组位置碰撞时，就会将碰撞的元素使用链表串接起来。

渐进式 rehash 会在 rehash 的同时，保留新旧两个 hash 结构，查询时会同时查询两个hash 结构，然后在后续的定时任务中以及 hash 的子指令中，循序渐进地将旧 hash 的内容一点点迁移到新的 hash 结构中。

当 hash 移除了最后一个元素之后，该数据结构自动被删除，内存被回收。 

hash 结构也可以用来存储用户信息，不同于字符串一次性需要全部序列化整个对象， hash 可以对用户结构中的每个字段单独存储。这样当我们需要获取用户信息时可以进行部分 获取。而以整个字符串的形式去保存用户信息的话就只能一次性全部读取，这样就会比较浪 费网络流量。 

hash 也有缺点，hash 结构的存储消耗要高于单个字符串，到底该使用 hash 还是字符 串，需要根据实际情况再三权衡。 

```java
> hset books java "think in java" # 命令行的字符串如果包含空格，要用引号括起来 (integer) 1
> hset books golang "concurrency in go"
(integer) 1
> hset books python "python cookbook"
(integer) 1
> hgetall books # entries()，key 和 value 间隔出现
1) "java"
2) "think in java"
3) "golang"
4) "concurrency in go"
5) "python"
6) "python cookbook"
> hlen books
(integer) 3
> hget books java
"think in java"
> hset books golang "learning go programming" # 因为是更新操作，所以返回 0 
  (integer) 0
> hget books golang "learning go programming"
> hmset books java "effective java" python "learning python" golang "modern golang
programming" # 批量 set 
  OK

```

* 计数

  同字符串一样，hash 结构中的单个子 key 也可以进行计数，它对应的指令是 hincrby，和 incr 使用基本一样。

```java
# 老钱又老了一岁
> hincrby user-laoqian age 1
(integer) 30
```

#### 4.set (集合)

Redis 的集合相当于 Java 语言里面的 HashSet，它内部的键值对是无序的唯一的。它的 内部实现相当于一个特殊的字典，字典中所有的 value 都是一个值 NULL。 

当集合中最后一个元素移除之后，数据结构自动删除，内存被回收。

 set 结构可以用来存储活动中奖的用户 ID，因为有去重功能，可以保证同一个用户不会中奖两次。 

```java
> sadd books python
(integer) 1
> sadd bookspython # 重复
(integer) 0
> sadd books java golang
(integer) 2
> smembers books # 注意顺序，和插入的并不一致，因为 set 是无序的
1) "java"
2) "python"
3) "golang"
> sismember books java # 查询某个 value 是否存在，相当于 contains(o) (integer) 1
> sismember books rust
(integer) 0
> scard books # 获取长度相当于 count()
(integer) 3
> spop books # 弹出一个
"java"
```

* zset (有序列表)

zset 可能是 Redis 提供的最为特色的数据结构，它也是在面试中面试官最爱问的数据结构。它类似于 Java 的 SortedSet 和 HashMap 的结合体，一方面它是一个 set，保证了内部value 的唯一性，另一方面它可以给每个 value 赋予一个 score，代表这个 value 的排序权重。它的内部实现用的是一种叫着「跳跃列表」的数据结构。

zset 中最后一个 value 被移除后，数据结构自动删除，内存被回收。 zset 可以用来存 粉丝列表，value 值是粉丝的用户 ID，score 是关注时间。我们可以对粉丝列表按关注时间 进行排序。 

zset 还可以用来存储学生的成绩，value 值是学生的 ID，score 是他的考试成绩。我们 可以对成绩按分数进行排序就可以得到他的名次。 

```java
> zadd books 9.0 "think in java"
(integer) 1
> zadd books 8.9 "java concurrency"
(integer) 1
> zadd books 8.6 "java cookbook"
(integer) 1
> zrange books 0 -1 # 按 score 排序列出，参数区间为排名范围
1) "java cookbook"
2) "java concurrency"
3) "think in java"
> zrevrange books 0 -1 # 按 score 逆序列出，参数区间为排名范围
1) "think in java"
2) "java concurrency"
3) "java cookbook"
> zcard books # 相当于 count()
(integer) 3
> zscore books "java concurrency" # 获取指定 value 的 score
"8.9000000000000004" # 内部 score 使用 double 类型进行存储，所以存在小数点精度问题
> zrank books "java concurrency" # 排名
(integer) 1
> zrangebyscore books 0 8.91 # 根据分值区间遍历 zset
1) "java cookbook"
2) "java concurrency"
> zrangebyscore books -inf 8.91 withscores # 根据分值区间 (-∞, 8.91] 遍历 zset，同时返
回分值。inf 代表 infinite，无穷大的意思。
1) "java cookbook"
2) "8.5999999999999996"
3) "java concurrency"
4) "8.9000000000000004"
> zrem books "java concurrency" # 删除 value (integer) 1
> zrange books 0 -1
1) "java cookbook"
2) "think in java"
```

* 跳跃列表

zset 内部的排序功能是通过「跳跃列表」数据结构来实现的，它的结构非常特殊，也比 较复杂。因为 zset 要支持随机的插入和删除，所以它不好使用数组来表示。我们先看一个普通的链表结构 。

想想一个创业公司，刚开始只有几个人，团队成员之间人人平等，都是联合创始人。随 着公司的成长，人数渐渐变多，团队沟通成本随之增加。这时候就会引入组长制，对团队进 行划分。每个团队会有一个组长。开会的时候分团队进行，多个组长之间还会有自己的会议 安排。公司规模进一步扩展，需要再增加一个层级 —— 部门，每个部门会从组长列表中推 选出一个代表来作为部长。部长们之间还会有自己的高层会议安排。 

跳跃列表就是类似于这种层级制，最下面一层所有的元素都会串起来。然后每隔几个元 素挑选出一个代表来，再将这几个代表使用另外一级指针串起来。然后在这些代表里再挑出 二级代表，再串起来。最终就形成了金字塔结构。 想想你老家在世界地图中的位置:亚洲- ->中国->安徽省->安庆市->枞阳县->汤沟镇->田间村->xxxx 号，也是这样一个类似的结构。

「跳跃列表」之所以「跳跃」，是因为内部的元素可能「身兼数职」，比如上图中间的 这个元素，同时处于 L0、L1 和 L2 层，可以快速在不同层次之间进行「跳跃」。

  定位插入点时，先在顶层进行定位，然后下潜到下一级定位，一直下潜到最底层找到合适的位置，将新元素插进去。你也许会问，那新插入的元素如何才有机会「身兼数职」呢?跳跃列表采取一个随机策略来决定新元素可以兼职到第几层。

首先 L0 层肯定是 100% 了，L1 层只有 50% 的概率，L2 层只有 25% 的概率，L3 层只有 12.5% 的概率，一直随机到最顶层 L3层。绝大多数元素都过不了几层，只有极少数元素可以深入到顶层。列表中的元素越多，能够深入的层次就越深，能进入到顶层的概率就会越大。

## 分布式锁

并发问题，因为读取和保存状态这两个操作不是原子的。

> 原子操作:是指不会被线程调度机制打断的操作;这种操作一旦开始，就一直运行到结束，中间不会有任何 context switch 线程切换。

### 1.锁

分布式锁本质上要实现的目标就是在 Redis 里面占一个“茅坑”。

占坑一般是使用 setnx(set if not exists) 指令，只允许被一个客户端占坑。先来先占， 用完了，再调用 del 指令释放茅坑。

```java
// 这里的冒号:就是一个普通的字符，没特别含义，它可以是任意其它字符，不要误解
> setnx lock:codehole true 
  OK
... do something critical ... 
  > del lock:codehole 
  (integer) 1
```

但是有个问题，如果逻辑执行到中间出现异常了，可能会导致 del 指令没有被调用，这样就会陷入死锁，锁永远得不到释放。 

于是我们在拿到锁之后，再给锁加上一个过期时间，比如 5s，这样即使中间出现异常也 可以保证 5 秒之后锁会自动释放。 

```java
> setnx lock:codehole true 
  OK
> expire lock:codehole 5 
  ... do something critical ... 
> del lock:codehole (integer) 1
```

但是以上逻辑还有问题。如果在 setnx 和 expire 之间服务器进程突然挂掉了，可能是因为机器掉电或者是被人为杀掉的，就会导致 expire 得不到执行，也会造成死锁。

>  问题根源：在于 setnx 和 expire 是两条指令而不是原子指令。如果这两条指令可以一起执行就不会出现问题。也许你会想到用 Redis 事务来解决。但是这里不行，因为 expire是依赖于 setnx 的执行结果的，如果 setnx 没抢到锁，expire 是不应该执行的。事务里没有 if-else 分支逻辑，事务的特点是一口气执行，要么全部执行要么一个都不执行。

#### 解决

```JAVA
Redis 2.8 版本中作者加入了 set 指令的扩展参数，使得 setnx 和expire 指令可以一起执行，彻底解决了分布式锁的乱象。

> set lock:codehole true ex 5 nx 
  OK ... 
  do something critical ... 
> del lock:codehole 
    
上面这个指令就是 setnx 和 expire 组合在一起的原子指令，它就是分布式锁的奥义所在
```

### 2.超时问题

现象：加锁和释放锁之间的逻辑执行时间过长，超过了锁的超时限制。因为这时候锁过期了，第二个线程重新持有了这把锁，但是紧接着第一个线程执行完了业务逻辑，就把锁给释放了，第三个线程就会在第二个线程逻辑执行完之间拿到了锁。（没锁住，串了）