package leetcode.editor.en;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 微盛门店表
 *
 * @author laichuanmin
 * @since 2022-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class WsShop implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 内部shopId
     */
    private Integer shopId;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 微盛shopId
     */
    private Long outShopId;

    /**
     * 员工活码图片id
     */
    private Integer qrCodeImgId;

    /**
     * 群活码图片路径
     */
    private String chatCodeImgUrl;

    /**
     * 门店状态 0 关闭 1 开启
     */
    private Boolean status;

    /**
     * 群活码id
     */
    private String chatCodeId;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 删除标志
     */
    private Long deleteFlag;

    /**
     * 入表时间
     */
    private LocalDateTime intoSysTime;

    /**
     * 入表更新时间
     */
    private LocalDateTime updateSysTime;


}
