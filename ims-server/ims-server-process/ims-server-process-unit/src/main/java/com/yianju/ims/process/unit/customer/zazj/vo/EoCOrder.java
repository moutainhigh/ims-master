package com.yianju.ims.process.unit.customer.zazj.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class EoCOrder extends Order implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     * 表物理ID主键
     */
    private Long eoorId;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 数据行版本号
     */
    private Long recVer;
    /**
     * 数据行状态(0:正常/1:删除)
     */
    private int recStatus;
    /**
     * 平台分公司
     */
    private String orgId;
    /**
     * 系统订单号
     */
    private String eoorOrderNo;
    /**
     * 承运商运单号
     */
    private String eoorCarrierTransNo;
    /**
     * 客户订单号，取上游系统（ECM等）的系统单号。
     */
    private String eoorLogisticNo;
    /**
     * 订单类型代码
     */
    private String eoorOrderTypeCode;
    /**
     * 订单类型名称(1.C网订单 2.B网订单 3.拦截单 4.换货单 5.退货订单 6.拒收订单)
     */
    private String eoorOrderTypeName;
    /**
     * （不需要）优先级代码
     */
    private String eoorPriorityCode;
    /**
     * （不需要）优先级名称
     */
    private String eoorPriorityName;
    /**
     * 运输方式代码
     */
    private String eoorTransTypeCode;
    /**
     * 运输方式名称
     */
    private String eoorTransTypeName;
    /**
     * 状态代码
     */
    private String eoorStatusCode;
    /**
     * 状态名称
     */
    private String eoorStatusName;
    /**
     * 客户代码
     */
    private String eoorCustomerCode;
    /**
     * 客户名称
     */
    private String eoorCustomerName;
    /**
     * 客户下单联系人代码
     */
    private String eoorCustomerContactCode;
    /**
     * 客户下单联系人名称
     */
    private String eoorCustomerContactName;
    /**
     * 客户下单联系人电话
     */
    private String eoorCustomerContactPhone;
    /**
     * （系统）接单时间
     */
    private Date eoorOrderTime;
    /**
     * 要求提货时间从
     */
    private Date eoorRequireShipperTimeFm;
    /**
     * 要求提货时间到
     */
    private Date eoorRequireShipperTimeTo;
    /**
     * 要求送达时间从
     */
    private Date eoorRequireConsigneeTimeFm;
    /**
     * 要求送达时间到
     */
    private Date eoorRequireConsigneeTimeTo;
    /**
     * 接单部门代码
     */
    private String eoorOrderDepartmentCode;
    /**
     * 接单部门名称
     */
    private String eoorOrderDepartmentName;
    /**
     * 操作部门代码
     */
    private String eoorOperateDepartmentCode;
    /**
     * 操作部门名称
     */
    private String eoorOperateDepartmentName;
    /**
     * 发货人代码
     */
    private String eoorShipperCode;
    /**
     * 发货人名称
     */
    private String eoorShipperName;
    /**
     * 发货联系人代码
     */
    private String eoorShipperContactCode;
    /**
     * 发货联系人名称
     */
    private String eoorShipperContactName;
    /**
     * 发货联系人电话
     */
    private String eoorShipperContactPhone;
    /**
     * 发货地点代码
     */
    private String eoorShipperLocationCode;
    /**
     * 发货地点名称
     */
    private String eoorShipperLocationName;
    /**
     * 发货区域代码
     */
    private String eoorShipperRegionCode;
    /**
     * 发货区域名称
     */
    private String eoorShipperRegionName;
    /**
     * 发货城市代码
     */
    private String eoorShipperCityCode;
    /**
     * 发货城市名称
     */
    private String eoorShipperCityName;
    /**
     * 发货县区代码
     */
    private String eoorShipperDistrictCode;
    /**
     * 发货县区名称
     */
    private String eoorShipperDistrictName;
    /**
     * 收货人代码
     */
    private String eoorConsigneeCode;
    /**
     * 收货人名称
     */
    private String eoorConsigneeName;
    /**
     * 收货联系人代码
     */
    private String eoorConsigneeContactCode;
    /**
     * 收货联系人名称
     */
    private String eoorConsigneeContactName;
    /**
     * 收货联系人电话
     */
    private String eoorConsigneeContactPhone;
    /**
     * 收货地点代码
     */
    private String eoorConsigneeLocationCode;
    /**
     * 收货地点名称
     */
    private String eoorConsigneeLocationName;
    /**
     * 收货区域代码
     */
    private String eoorConsigneeRegionCode;
    /**
     * 收货区域名称
     */
    private String eoorConsigneeRegionName;
    /**
     * 收货城市代码
     */
    private String eoorConsigneeCityCode;
    /**
     * 收货城市名称
     */
    private String eoorConsigneeCityName;
    /**
     * 收货县区代码
     */
    private String eoorConsigneeDistrictCode;
    /**
     * 收货县区名称
     */
    private String eoorConsigneeDistrictName;
    /**
     * （不需要）订单条码
     */
    private String eoorBarcode;
    /**
     * 订单来源代码
     */
    private String eoorSourceCode;
    /**
     * 订单来源平台（1、京东；2、天猫）
     */
    private String eoorSourceName;
    /**
     * 总包装数
     */
    private Double eoorPackageQuantity;
    /**
     * 总件数
     */
    private Double eoorQuantity;
    /**
     * 总毛重
     */
    private Double eoorGrossWeight;
    /**
     * 总净重
     */
    private Double eoorNetWeight;
    /**
     * 总体积
     */
    private Double eoorVolume;
    /**
     * 特殊要求
     */
    private String eoorRequirement;
    /**
     * 备注
     */
    private String eoorRemark;
    /**
     * 关联客户订单号
     */
    private String eoorLinkOrderNo;
    /**
     * 合并标识
     */
    private String eoorMegerFlag;
    /**
     * 失效日期
     */
    private Date eoorExpirationTime;
    /**
     * 是否需要预约。0-否；1-是
     */
    private String eoorReservation;
    /**
     * （不需要）业务员代码
     */
    private String eoorSalesmanCode;
    /**
     * （不需要）业务员名称
     */
    private String eoorSalesmanName;
    /**
     * 拆分标识
     */
    private String eoorSplitFlag;
    /**
     * 紧急订单标识（Y/N）
     */
    private String eoorEmergentFlag;
    /**
     * 状态颜色
     */
    private String eoorStatusColor;
    /**
     * （不需要）事件对象类型代码
     */
    private String eoorEventObjectCode;
    /**
     * （不需要）事件对象类型名称
     */
    private String eoorEventObjectName;
    /**
     * 付款方式代码
     */
    private String eoorPaymentTypeCode;
    /**
     * 付款方式名称
     */
    private String eoorPaymentTypeName;
    /**
     * 始发仓库代码
     */
    private String eoorWarehouserCode;
    /**
     * 始发仓库名称
     */
    private String eoorWarehouserName;
    /**
     * （不需要）始发基地代码
     */
    private String eoorStationCode;
    /**
     * （不需要）始发基地名称
     */
    private String eoorStationName;
    /**
     * Y表示可编辑，N表示不可编辑，新增默认为Y
     */
    private String eoorEditable;
    /**
     * 总金额
     */
    private Double eoorAmount;
    /**
     * 代收货款
     */
    private String eoorCollectionDelivery;
    /**
     * 代收金额
     */
    private Double eoorCollectionAmount;
    /**
     * 销售客户代码
     */
    private String eoorSellingCustomerCode;
    /**
     * 销售客户名称
     */
    private String eoorSellingCustomerName;
    /**
     * 事件状态代码
     */
    private String eoorEventStatusCode;
    /**
     * 状态备注
     */
    private String eoorStatusRemark;
    /**
     * 客单号
     */
    private String eoorMainOrderNo;
    /**
     * （不需要）速必达单号
     */
    private String eoorSpdNo;
    /**
     * （不需要）单号
     */
    private String eoorOpsNo;
    /**
     * （不需要）运单号
     */
    private String eoorTransNo;
    /**
     * （不需要）二级单号
     */
    private String eoorSecondTransNo;
    /**
     * 客户/电商下单时间
     */
    private Date eoorCustomerOrderTime;
    /**
     * （不需要）下单时间
     */
    private Date eoorSpdOrderTime;
    /**
     * 要求提货时间
     */
    private Date eoorRequireShipperTime;
    /**
     * 要求送货时间
     */
    @XmlElement(name = "eoorRequireConsigneeTime")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date eoorRequireConsigneeTime;
    /**
     * 承运商CODE
     */
    private String eoorCarrierCode;
    /**
     * 承运商
     */
    private String eoorCarrierName;
    /**
     * 拦截状态（拦截单才有的状态）
     */
    private String eoorIntercepStatusCode;
    /**
     * 接力点CODE（门店）
     */
    private String eoorTransitHubCode;
    /**
     * 接力点（门店）
     */
    private String eoorTransitHubName;
    /**
     * 供货商CODE
     */
    private String eoorSupplierCode;
    /**
     * 供货商
     */
    private String eoorSupplierName;
    /**
     * 正反向：Y、正向 N、反向（当类型是换货单、退货单时是方向）
     */
    private String eoorIsPositive;
    /**
     * 发货省代码
     */
    private String eoorShipperProvinceCode;
    /**
     * 发货省
     */
    private String eoorShipperProvinceName;
    /**
     * 发货地址名称
     */
    private String eoorShipperAddress;
    /**
     * 收货联系人电话
     */
    private String eoorConsigneeContactTel;
    /**
     * 收货省代码
     */
    private String eoorConsigneeProvinceCode;
    /**
     * 收货省名称
     */
    private String eoorConsigneeProvinceName;
    /**
     * 收货街道代码
     */
    private String eoorConsigneeStreetCode;
    /**
     * 收货街道名称
     */
    private String eoorConsigneeStreetName;
    /**
     * 收货地址
     */
    private String eoorConsigneeAddress;
    /**
     * 买家备注
     */
    private String eoorBuyerRemark;
    /**
     * 卖家备注
     */
    private String eoorSellerRemark;
    /**
     * 是否一口价 Y是 N 否
     */
    private String eoorIsFreight;
    /**
     * 一口价金额
     */
    private Double eoorPretreatmentTotalFee;
    /**
     * 货值
     */
    private Double eoorCargoValue;
    /**
     * 是否允许自动下发(Y:是；N:否)
     */
    private String eoorIsEqualPayment;
    /**
     * 是否货票同行(Y/N)
     */
    private String eoorIsWaybill;
    /**
     * 开票要求
     */
    private String eoorInvoiceRequest;
    /**
     * 是否上楼
     */
    private String eoorIsUpstair;
    /**
     * 是否配送
     */
    private String eoorDelierySetupType;
    /**
     * 时效（H）
     */
    private Double eoorTransTime;
    /**
     * 接单客服CODE
     */
    private String eoorCustomServiceCode;
    /**
     * 接单客服
     */
    private String eoorCustomServiceName;
    /**
     * 客服备注
     */
    private String eoorCustomServiceRemark;
    /**
     * （不需要）是否紧急
     */
    private String eoorIsEmergency;
    /**
     * 驳回原因
     */
    private String eoorRejectReason;
    /**
     * 驳回时间
     */
    private Date eoorRejectDate;
    /**
     * 是否发货预约
     */
    private String eoorIsShipperAppoint;
    /**
     * 发货预约时间
     */
    private Date eoorShipperAppointDate;
    /**
     * 是否收货预约
     */
    private String eoorIsConsigneeAppoint;
    /**
     * 收货预约时间
     */
    private Date eoorConsigneeAppointDate;
    /**
     * 付款状态：P1-已付款，P2-代收货款
     */
    private String eoorPayStatus;
    /**
     * 是否需要开具发票
     */
    private String eoorIsInvoice;
    /**
     * 发票类型
     */
    private String eoorInvoiceType;
    /**
     * 发票抬头
     */
    private String eoorInvoiceTitle;
    /**
     * 派送类型: 1.自提，0. 非自提
     */
    private String eoorDeliveryType;
    /**
     * 派送时间类型: 1.只工作日派送，2.只周末派送
     */
    private String eoorDeliveryDateType;
    /**
     * 是否需要签回单：N 不需要回执；Y 需要回执单
     */
    private String eoorIsPod;
    /**
     * 业务处理结果: 创建订单时 是否满足派送要求1.换货方超范围2.目的地超范围
     */
    private String eoorBusinessResult;
    /**
     * （不需要）原单号(退货单用) 退换货关联单号
     */
    private String eoorOriginalOpsNo;
    /**
     * （第三方平台订单号）原系统单订单号
     */
    private String eoorOriginalOrderNo;
    /**
     * 应出库时间
     */
    private Date eoorOutboundTime;
    /**
     * 到门店时间
     */
    private Date eoorHubReceiveTime;
    /**
     * 付款时间
     */
    private Date eoorPayTime;
    /**
     * 财务审批时间
     */
    private Date eoorFinanceApprovalTime;
    /**
     * （不需要）任务单号
     */
    private String eoorSpdWorkNo;
    /**
     * 支付类别（如支付宝、现金、银联等)
     */
    private String eoorCargoPayType;
    /**
     * 预约安装时间
     */
    private Date eoorInstallDate;
    /**
     * （不需要）是否电商订单
     */
    private String eoorIsB2c;
    /**
     * 包装要求
     */
    private String eoorPackageRequire;
    /**
     * 收货联系人证件号
     */
    private String eoorConsigneeContactIdCard;
    /**
     * 物流预约发货时间
     */
    private Date eoorLogisticsSendDate;
    /**
     * 物流预约收货时间
     */
    private Date eoorLogisticsReceiveDate;
    /**
     * 建议承运商CODE
     */
    private String eoorAdviseCarrierCode;
    /**
     * 建议承运商
     */
    private String eoorAdviseCarrierName;
    /**
     * 发货街道代码
     */
    private String eoorShipperStreetCode;
    /**
     * 发货街道
     */
    private String eoorShipperStreetName;
    /**
     * 发送方代码
     */
    private String eoorEdiSenderCode;
    /**
     * 实际承运商
     */
    private String eoorFactCarrierCode;
    /**
     * 实际承运商
     */
    private String eoorFactCarrierName;
    /**
     * 发货联系人手机
     */
    private String eoorShipperContactTel;
    /**
     * 原寄地代码
     */
    private String eoorOrigPlaceCode;
    /**
     * 目的寄地代码
     */
    private String eoorDescPlaceCode;
    /**
     * 商铺信息
     */
    private String eoorStoreName;
    /**
     * 异常状态
     */
    private String eoorExceptionStatus;
    /**
     * 是否计算费用
     */
    private String eoorIsCountFee;
    /**
     * 重量体积
     */
    private Double eoorWeightVolume;
    /**
     * 客户单据类型
     */
    private String eoorCustomerType;
    /**
     * 开单方
     */
    private String eoorSubscriber;
    /**
     * （不需要）波次号
     */
    private String eoorWaveCode;
    /**
     * （不需要）发票关联号
     */
    private String eoorSaleCode;
    /**
     * （不需要）短单号
     */
    private String eoorShortCode;
    /**
     * 原件数
     */
    private Double eoorOriginalQty;
    /**
     * 是否全冲
     */
    private String eoorIsAllIntercept;
    /**
     * 是否运输：Y/N
     */
    private String eoorIsTransport;
    /**
     * 是否生成出库单：Y/N
     */
    private String eoorIsStorckOut;
    /**
     * 是否生成入库单:Y/N
     */
    private String eoorIsStorckIn;
    /**
     * 拦截点CODE
     */
    private String eoorPointCode;
    /**
     * 拦截点NAME
     */
    private String eoorPointName;
    /**
     * （不需要）是否下发：Y/N
     */
    private String eoorIsSendSpd;
    /**
     * 是否班车：Y/N
     */
    private String eoorHasLine;
    /**
     * 序号
     */
    private String eoorSequence;
    /**
     * （不需要）波次总数
     */
    private Double eoorWaveTotal;
    /**
     * （不需要）波次号是否同步
     */
    private String eoorIsWaveSync;
    /**
     * 客审时间
     */
    private Date eoorCustomerApprovalTime;
    /**
     * 商审时间
     */
    private Date eoorBusinessApprovalTime;
    /**
     * 实际出库时间
     */
    private Date eoorFactOutboundTime;
    /**
     * （不需要）拣货时间
     */
    private Date eoorPickingGoods;
    /**
     * （不需要）退货确认时间
     */
    private Date eoorConfirmReturnTime;
    /**
     * （不需要）操作基地是否标识：Y/N
     */
    private String eoorIsJlp;
    /**
     * （不需要）入库时间
     */
    private Date eoorStorckIn;
    /**
     * （不需要）是否成功同步税控机：Y/N
     */
    private String eoorIsSyncTaxPrinter;
    /**
     * 是否提货
     */
    private String eoorTransChange;
    /**
     * （不需要）是否打印
     */
    private String eoorIsPrint;
    /**
     * （不需要）打印次数
     */
    private Long eoorPrintCount;
    /**
     * （不需要）设置波次时间
     */
    private Date eoorWaveTime;
    /**
     * （不需要）下发客音时间
     */
    private Date eoorKeyinTime;
    /**
     * （不需要）运输方
     */
    private String eoorTransParty;
    /**
     * （不需要）物流单号
     */
    private String eoorSpdLogisticNo;
    /**
     * （不需要）计费时间
     */
    private Date eoorCountFeeTime;
    /**
     * （新增）订单执行状态
     */
    private String eoorExecuteStatus;
    /**
     * （新增）结算标识
     */
    private String eoorFaFlag;
    /**
     * （新增）指定财务仓代码
     */
    private String eoorInventoryWhCode;
    /**
     * （新增）指定财务仓名称
     */
    private String eoorInventoryWhName;
    /**
     * （新增）服务平台代码
     */
    private String esstCode;
    /**
     * （新增）服务平台名称
     */
    private String esstName;
    /**
     * （新增）物权所有者代码
     */
    private String eoorPropertyOwnerCode;
    /**
     * （新增）物权所有者
     */
    private String eoorPropertyOwner;
    /**
     * （新增）（ECM/富润/管易/手工）订单来源名称
     */
    private String eoorPlatformCode;
    /**
     * （新增）优惠活动类型
     */
    private String eoorPromtionType;
    /**
     * （新增）路线
     */
    private String eoorLine;
    /**
     * （新增）里程
     */
    private Double eoorMileage;
    /**
     * （新增）冲销原因
     */
    private String eoorChargeAgainstReason;
    /**
     * （新增）买家网上下单时间
     */
    private Date eoorBuyerOrderTime;
    /**
     * （新增）发货预约时间从
     */
    private Date eoorShipperBookingDateFrom;
    /**
     * （新增）发货预约时间到
     */
    private Date eoorShipperBookingDateTo;
    /**
     * （新增）付款方式
     */
    private String eoorPaymentWay;
    /**
     * （新增）分公司
     */
    private String companyCode;
    /**
     * （新增）服务平台
     */
    private String siteCode;
    /**
     * （新增）发货乡镇
     */
    private String eoorShipperVillageName;
    /**
     * （新增）发货乡镇代码
     */
    private String eoorShipperVillageCode;
    /**
     * （新增）收货乡镇
     */
    private String eoorConsigneeVillageName;
    /**
     * （新增）收货乡镇代码
     */
    private String eoorConsigneeVillageCode;
    /**
     * （新增）预约状态
     */
    private String eoorReservationStatus;
    /**
     * （新增）预约送达时间
     */
    @XmlElement(name = "eoorReservationArrivalTime")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date eoorReservationArrivalTime;
    /**
     * （新增）预计送达时间
     */
    private Date eoorExcpeptTime;
    /**
     * （新增）预约时间
     */
    private Date eoorReservationTime;
    /**
     * （新增）预约下发时间
     */
    private Date eoorReservationIssueTime;
    /**
     * （新增）分公司-名称
     */
    private String companyName;
    /**
     * （新增）服务平台-名称
     */
    private String siteName;
    /**
     * （新增）是否代收货款
     */
    private Long eoorIsCollectionAmount;
    /**
     * （新增）是否节假日收货
     */
    private Long eoorIsTakeDeliveryHoliday;
    /**
     * （新增）退货原因
     */
    private String eoorReturnGoodsReason;
    /**
     * 解析状态：新增（0）、地址解析（1）、分仓（2）、承运商分配（3）
     */
    private Long eoorParseStatus;
    /**
     * 超图解析区划
     */
    private String eoorParseArea;
    /**
     * 超图解析网点
     */
    private String eoorParseNetpoint;
    /**
     * （新增）收货仓库代码
     */
    private String eoorConsigneeWarehouserCode;
    /**
     * （新增）收货仓库名称
     */
    private String eoorConsigneeWarehouserName;
    /**
     * 确认标识 1：整单确认 2：多次确认
     */
    private String eoorReturnFlag;
    /**
     * 优惠金额
     */
    private Double eoorDiscountAmount;
    /**
     * 应付金额
     */
    private Double eoorPaymentAmount;
    /**
     * 店铺信息pm_code
     */
    private String eoorEosmPmCode;
    /**
     * 发票总额
     */
    private Double eoorInvoiceAmount;
    /**
     * 快递单号
     */
    private String eoorExpressNo;
    /**
     * 预计下发时间
     */
    private Date eoorExceptIssueTime;
    /**
     * 物流产品CODE
     */
    private String eoorEblpCode;
    /**
     * 物流产品NAME
     */
    private String eoorEblpName;
    /**
     * 发货地经度
     */
    private String eoorShipperLongitude;
    /**
     * 发货地纬度
     */
    private String eoorShipperLatitude;
    /**
     * 收货地经度
     */
    private String eoorConsigneeLongitude;
    /**
     * 收货地纬度
     */
    private String eoorConsigneeLatitude;
    /**
     * 经度
     */
    private String eoorLongitude;
    /**
     * 纬度
     */
    private String eoorLatitude;
    /**
     * (新增)预约送达时间到
     */
    private Date eoorBookArrivalTimeTo;
    /**
     * 是否指定承运商
     */
    private String eoorSpecCarrier;
    /**
     * 是否外包
     */
    private String eoorIsOutsource;
    /**
     * 快递包裹明细
     */
    private String eoorPackageItems;
    /**
     * 接力点类型
     */
    private String eoorTransitHubType;
    /**
     * 实际入库时间
     */
    private Date eoorFactInboundTime;
    /**
     * 是否需要安装
     */
    private String eoorIsInstall;
    /**
     * 销售日期（新增）
     */
    private Date eoorSalesDate;
    /**
     * 渠道 下拉框取值（新增）
     */
    private String eoorChannel;
    /**
     * 经营单位（新增）
     */
    private String eoorBusinessUnits;
    /**
     * 经营单位备注（新增）
     */
    private String eoorBusinessUnitsInfo;
    /**
     * 摘要（新增）
     */
    private String eoorAbstract;
    /**
     * 其他说明（新增）
     */
    private String eoorOtherInstructions;
    /**
     * 销售渠道
     */
    private String eoorSaleChannel;
    /**
     * 业务员
     */
    private String eoorSaleman;
    /**
     * 有无电梯
     */
    private String eoorIsLift;
    /**
     * 服务费(存放的是服务费，对于家装来说，存放的是服务费)
     */
    private Double eoorServiceFee;
    /**
     * 收货人邮编
     */
    private String eoorReceiverZip;
    /**
     * 收货人邮编
     */
    private String eoorSenderZip;
    /**
     * 楼层
     */
    private Long eoorFloor;
    /**
     * 运单号（在自动生成运单号，回传菜鸟）
     */
    private String eoorTransNoCn;
    /**
     * 工单类型(1-任务，2合同)
     */
    private String eoorWorkType;
    /**
     * 服务次数
     */
    private Long eoorServiceCount;
    /**
     * 买家邮箱
     */
    private String eoorBuyerMail;
    /**
     * 工单id
     */
    private String eoorContractId;
    /**
     * 工单名称
     */
    private String eoorName;
    /**
     * 收货日期
     */
    private Long eoorReceiveTimeNumber;
    /**
     * 失效日期
     */
    private Date eoorExpireDate;
    /**
     * 无需安装原因
     */
    private String eoorRefuseReason;
    /**
     * 服务类型编码
     */
    private String eoorServiceTypeCode;
    /**
     * 支付方式编码
     */
    private String eoorPayTypeCode;
    /**
     * 送货方式编码
     */
    private String eoorDeliveryTypeCode;
    /**
     * 签收回单编码
     */
    private String eoorBackSignBillCode;
    /**
     * 是否直送
     */
    private String eoorIsDirectSend;
    /**
     * 订单销售日期
     */
    private Date eoorSaleTime;
    /**
     * 导购业务员联系方式
     */
    private String eoorSalemanContact;
    /**
     * 是否回单.0-否，1-是
     */
    private String eoorIsReceipt;
    /**
     * 费用申请
     */
    private String eoorCostApply;
    /**
     * 无需安装操作人
     */
    private String eoorNoNeedInstallOperator;
    /**
     * 无需安装操作时间
     */
    private Date eoorNoNeedInstallDate;
    /**
     * 无需安装原因
     */
    private String eoorNoNeedInstallReason;
    /**
     * 无需安装是否反馈成功
     */
    private String eoorNoNeedInstallStatus;
    /**
     * 无需安装反馈结果
     */
    private String eoorNoNeedInstallReasult;
    /**
     * 配送服务区域代码
     */
    private String eoorDeliverAreaCode;
    /**
     * 是否维保期内(维修单是否需要收费标记)
     */
    private String eoorIsMaintenancePeriod;
    /**
     * 是否暂办。0-否；1-是
     */
    private String eoorIsTemporary;
    /**
     * 改期原因
     */
    private String eoorTemporaryExplain;
    /**
     * 菜鸟单订单类型
     */
    private String eoorRookieType;
    /**
     * 菜鸟单状态
     */
    private String eoorRookieStatus;
    /**
     * 发货联系人公司
     */
    private String eoorShipperContactCompany;
    /**
     * 发货人国家
     */
    private String eoorSenderCountry;
    /**
     * 发货方扩展信息
     */
    private String eoorShipperExtendfileds;
    /**
     * 收货联系人公司
     */
    private String eoorConsigneeContactCompany;
    /**
     * 收货联系人旺旺
     */
    private String eoorConsigneeContactWw;
    /**
     * 收货联系人国家
     */
    private String eoorConsigneeContactCountry;
    /**
     * 收货方扩展信息
     */
    private String eoorConsigneeExtendfileds;
    /**
     * 承运商类型
     */
    private String eoorCarrierType;
    /**
     * 承运商所在地
     */
    private String eoorCarrierAddress;
    /**
     * 承运商扩展信息
     */
    private String eoorCarrierExtendfileds;
    /**
     * 承运商备注
     */
    private String eoorCarrierRemark;
    /**
     * 运单
     */
    private String eoorUpsysFormerNo;
    private String eoorDriverCode;// 司机编码
    private String eoorDriverName;// 司机名称
    private String eoorVerhicleCode;// 车牌号
    private String eoorVerhicleName;// 车辆名称
    private String eoorrookieFalg;// 菜鸟反馈标示
    private String eoorTemporaryReason;// 暂办原因
    private String eoorRefundApplicationNo;// 退货申请号
    
 

    List<EoCOrderItem> inOrderReceiveItemNewBean;
    
    private EoCOrderExtension eoCOrderExtensionBean;
    
    /**
     * 分拣号
     */
    private String eoorSortingCode;
    
    private String eoorIsSupplement;

    /**
     * 是否导出
     */
    private String eoorIsExport;
    // 仓储单号
    private String eoorWmsOrderNo;
    /**
     * 改约时间   2017.8.14李永朋添加
     */
    private Date changeTime;
    //导购
    private String eoorPurChasingGuide;
    //美得你下属公司
    private String eoorSubordinateCompanyCode;
    
    //商品货值
    private String eoorGoodsValue;
    /**
     * 德邦收货部门编码
     */
    private String eoorDebonReceiveDeptCode;
    
    private String msgData;//订单报文信息，用于日志记录
    
	public String getMsgData() {
		return msgData;
	}
	public void setMsgData(String msgData) {
		this.msgData = msgData;
	}
	public String getEoorGoodsValue() {
		return eoorGoodsValue;
	}
	public void setEoorGoodsValue(String eoorGoodsValue) {
		this.eoorGoodsValue = eoorGoodsValue;
	}
	/**
     * 提货时间
     */
    @XmlElement(name = "eoorTakingDeliveryDate")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private Date eoorTakingDeliveryDate;
    
	public Date getEoorTakingDeliveryDate() {
		return eoorTakingDeliveryDate;
	}
	public void setEoorTakingDeliveryDate(Date eoorTakingDeliveryDate) {
		this.eoorTakingDeliveryDate = eoorTakingDeliveryDate;
	}
	public String getEoorPurChasingGuide() {
		return eoorPurChasingGuide;
	}
	public void setEoorPurChasingGuide(String eoorPurChasingGuide) {
		this.eoorPurChasingGuide = eoorPurChasingGuide;
	}
	public Long getEoorId() {
		return eoorId;
	}
	public void setEoorId(Long eoorId) {
		this.eoorId = eoorId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Long getRecVer() {
		return recVer;
	}
	public void setRecVer(Long recVer) {
		this.recVer = recVer;
	}
	public int getRecStatus() {
		return recStatus;
	}
	public void setRecStatus(int recStatus) {
		this.recStatus = recStatus;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getEoorOrderNo() {
		return eoorOrderNo;
	}
	public void setEoorOrderNo(String eoorOrderNo) {
		this.eoorOrderNo = eoorOrderNo;
	}
	public String getEoorCarrierTransNo() {
		return eoorCarrierTransNo;
	}
	public void setEoorCarrierTransNo(String eoorCarrierTransNo) {
		this.eoorCarrierTransNo = eoorCarrierTransNo;
	}
	public String getEoorLogisticNo() {
		return eoorLogisticNo;
	}
	public void setEoorLogisticNo(String eoorLogisticNo) {
		this.eoorLogisticNo = eoorLogisticNo;
	}
	public String getEoorOrderTypeCode() {
		return eoorOrderTypeCode;
	}
	public void setEoorOrderTypeCode(String eoorOrderTypeCode) {
		this.eoorOrderTypeCode = eoorOrderTypeCode;
	}
	public String getEoorOrderTypeName() {
		return eoorOrderTypeName;
	}
	public void setEoorOrderTypeName(String eoorOrderTypeName) {
		this.eoorOrderTypeName = eoorOrderTypeName;
	}
	public String getEoorPriorityCode() {
		return eoorPriorityCode;
	}
	public void setEoorPriorityCode(String eoorPriorityCode) {
		this.eoorPriorityCode = eoorPriorityCode;
	}
	public String getEoorPriorityName() {
		return eoorPriorityName;
	}
	public void setEoorPriorityName(String eoorPriorityName) {
		this.eoorPriorityName = eoorPriorityName;
	}
	public String getEoorTransTypeCode() {
		return eoorTransTypeCode;
	}
	public void setEoorTransTypeCode(String eoorTransTypeCode) {
		this.eoorTransTypeCode = eoorTransTypeCode;
	}
	public String getEoorTransTypeName() {
		return eoorTransTypeName;
	}
	public void setEoorTransTypeName(String eoorTransTypeName) {
		this.eoorTransTypeName = eoorTransTypeName;
	}
	public String getEoorStatusCode() {
		return eoorStatusCode;
	}
	public void setEoorStatusCode(String eoorStatusCode) {
		this.eoorStatusCode = eoorStatusCode;
	}
	public String getEoorStatusName() {
		return eoorStatusName;
	}
	public void setEoorStatusName(String eoorStatusName) {
		this.eoorStatusName = eoorStatusName;
	}
	public String getEoorCustomerCode() {
		return eoorCustomerCode;
	}
	public void setEoorCustomerCode(String eoorCustomerCode) {
		this.eoorCustomerCode = eoorCustomerCode;
	}
	public String getEoorCustomerName() {
		return eoorCustomerName;
	}
	public void setEoorCustomerName(String eoorCustomerName) {
		this.eoorCustomerName = eoorCustomerName;
	}
	public String getEoorCustomerContactCode() {
		return eoorCustomerContactCode;
	}
	public void setEoorCustomerContactCode(String eoorCustomerContactCode) {
		this.eoorCustomerContactCode = eoorCustomerContactCode;
	}
	public String getEoorCustomerContactName() {
		return eoorCustomerContactName;
	}
	public void setEoorCustomerContactName(String eoorCustomerContactName) {
		this.eoorCustomerContactName = eoorCustomerContactName;
	}
	public String getEoorCustomerContactPhone() {
		return eoorCustomerContactPhone;
	}
	public void setEoorCustomerContactPhone(String eoorCustomerContactPhone) {
		this.eoorCustomerContactPhone = eoorCustomerContactPhone;
	}
	public Date getEoorOrderTime() {
		return eoorOrderTime;
	}
	public void setEoorOrderTime(Date eoorOrderTime) {
		this.eoorOrderTime = eoorOrderTime;
	}
	public Date getEoorRequireShipperTimeFm() {
		return eoorRequireShipperTimeFm;
	}
	public void setEoorRequireShipperTimeFm(Date eoorRequireShipperTimeFm) {
		this.eoorRequireShipperTimeFm = eoorRequireShipperTimeFm;
	}
	public Date getEoorRequireShipperTimeTo() {
		return eoorRequireShipperTimeTo;
	}
	public void setEoorRequireShipperTimeTo(Date eoorRequireShipperTimeTo) {
		this.eoorRequireShipperTimeTo = eoorRequireShipperTimeTo;
	}
	public Date getEoorRequireConsigneeTimeFm() {
		return eoorRequireConsigneeTimeFm;
	}
	public void setEoorRequireConsigneeTimeFm(Date eoorRequireConsigneeTimeFm) {
		this.eoorRequireConsigneeTimeFm = eoorRequireConsigneeTimeFm;
	}
	public Date getEoorRequireConsigneeTimeTo() {
		return eoorRequireConsigneeTimeTo;
	}
	public void setEoorRequireConsigneeTimeTo(Date eoorRequireConsigneeTimeTo) {
		this.eoorRequireConsigneeTimeTo = eoorRequireConsigneeTimeTo;
	}
	public String getEoorOrderDepartmentCode() {
		return eoorOrderDepartmentCode;
	}
	public void setEoorOrderDepartmentCode(String eoorOrderDepartmentCode) {
		this.eoorOrderDepartmentCode = eoorOrderDepartmentCode;
	}
	public String getEoorOrderDepartmentName() {
		return eoorOrderDepartmentName;
	}
	public void setEoorOrderDepartmentName(String eoorOrderDepartmentName) {
		this.eoorOrderDepartmentName = eoorOrderDepartmentName;
	}
	public String getEoorOperateDepartmentCode() {
		return eoorOperateDepartmentCode;
	}
	public void setEoorOperateDepartmentCode(String eoorOperateDepartmentCode) {
		this.eoorOperateDepartmentCode = eoorOperateDepartmentCode;
	}
	public String getEoorOperateDepartmentName() {
		return eoorOperateDepartmentName;
	}
	public void setEoorOperateDepartmentName(String eoorOperateDepartmentName) {
		this.eoorOperateDepartmentName = eoorOperateDepartmentName;
	}
	public String getEoorShipperCode() {
		return eoorShipperCode;
	}
	public void setEoorShipperCode(String eoorShipperCode) {
		this.eoorShipperCode = eoorShipperCode;
	}
	public String getEoorShipperName() {
		return eoorShipperName;
	}
	public void setEoorShipperName(String eoorShipperName) {
		this.eoorShipperName = eoorShipperName;
	}
	public String getEoorShipperContactCode() {
		return eoorShipperContactCode;
	}
	public void setEoorShipperContactCode(String eoorShipperContactCode) {
		this.eoorShipperContactCode = eoorShipperContactCode;
	}
	public String getEoorShipperContactName() {
		return eoorShipperContactName;
	}
	public void setEoorShipperContactName(String eoorShipperContactName) {
		this.eoorShipperContactName = eoorShipperContactName;
	}
	public String getEoorShipperContactPhone() {
		return eoorShipperContactPhone;
	}
	public void setEoorShipperContactPhone(String eoorShipperContactPhone) {
		this.eoorShipperContactPhone = eoorShipperContactPhone;
	}
	public String getEoorShipperLocationCode() {
		return eoorShipperLocationCode;
	}
	public void setEoorShipperLocationCode(String eoorShipperLocationCode) {
		this.eoorShipperLocationCode = eoorShipperLocationCode;
	}
	public String getEoorShipperLocationName() {
		return eoorShipperLocationName;
	}
	public void setEoorShipperLocationName(String eoorShipperLocationName) {
		this.eoorShipperLocationName = eoorShipperLocationName;
	}
	public String getEoorShipperRegionCode() {
		return eoorShipperRegionCode;
	}
	public void setEoorShipperRegionCode(String eoorShipperRegionCode) {
		this.eoorShipperRegionCode = eoorShipperRegionCode;
	}
	public String getEoorShipperRegionName() {
		return eoorShipperRegionName;
	}
	public void setEoorShipperRegionName(String eoorShipperRegionName) {
		this.eoorShipperRegionName = eoorShipperRegionName;
	}
	public String getEoorShipperCityCode() {
		return eoorShipperCityCode;
	}
	public void setEoorShipperCityCode(String eoorShipperCityCode) {
		this.eoorShipperCityCode = eoorShipperCityCode;
	}
	public String getEoorShipperCityName() {
		return eoorShipperCityName;
	}
	public void setEoorShipperCityName(String eoorShipperCityName) {
		this.eoorShipperCityName = eoorShipperCityName;
	}
	public String getEoorShipperDistrictCode() {
		return eoorShipperDistrictCode;
	}
	public void setEoorShipperDistrictCode(String eoorShipperDistrictCode) {
		this.eoorShipperDistrictCode = eoorShipperDistrictCode;
	}
	public String getEoorShipperDistrictName() {
		return eoorShipperDistrictName;
	}
	public void setEoorShipperDistrictName(String eoorShipperDistrictName) {
		this.eoorShipperDistrictName = eoorShipperDistrictName;
	}
	public String getEoorConsigneeCode() {
		return eoorConsigneeCode;
	}
	public void setEoorConsigneeCode(String eoorConsigneeCode) {
		this.eoorConsigneeCode = eoorConsigneeCode;
	}
	public String getEoorConsigneeName() {
		return eoorConsigneeName;
	}
	public void setEoorConsigneeName(String eoorConsigneeName) {
		this.eoorConsigneeName = eoorConsigneeName;
	}
	public String getEoorConsigneeContactCode() {
		return eoorConsigneeContactCode;
	}
	public void setEoorConsigneeContactCode(String eoorConsigneeContactCode) {
		this.eoorConsigneeContactCode = eoorConsigneeContactCode;
	}
	public String getEoorConsigneeContactName() {
		return eoorConsigneeContactName;
	}
	public void setEoorConsigneeContactName(String eoorConsigneeContactName) {
		this.eoorConsigneeContactName = eoorConsigneeContactName;
	}
	public String getEoorConsigneeContactPhone() {
		return eoorConsigneeContactPhone;
	}
	public void setEoorConsigneeContactPhone(String eoorConsigneeContactPhone) {
		this.eoorConsigneeContactPhone = eoorConsigneeContactPhone;
	}
	public String getEoorConsigneeLocationCode() {
		return eoorConsigneeLocationCode;
	}
	public void setEoorConsigneeLocationCode(String eoorConsigneeLocationCode) {
		this.eoorConsigneeLocationCode = eoorConsigneeLocationCode;
	}
	public String getEoorConsigneeLocationName() {
		return eoorConsigneeLocationName;
	}
	public void setEoorConsigneeLocationName(String eoorConsigneeLocationName) {
		this.eoorConsigneeLocationName = eoorConsigneeLocationName;
	}
	public String getEoorConsigneeRegionCode() {
		return eoorConsigneeRegionCode;
	}
	public void setEoorConsigneeRegionCode(String eoorConsigneeRegionCode) {
		this.eoorConsigneeRegionCode = eoorConsigneeRegionCode;
	}
	public String getEoorConsigneeRegionName() {
		return eoorConsigneeRegionName;
	}
	public void setEoorConsigneeRegionName(String eoorConsigneeRegionName) {
		this.eoorConsigneeRegionName = eoorConsigneeRegionName;
	}
	public String getEoorConsigneeCityCode() {
		return eoorConsigneeCityCode;
	}
	public void setEoorConsigneeCityCode(String eoorConsigneeCityCode) {
		this.eoorConsigneeCityCode = eoorConsigneeCityCode;
	}
	public String getEoorConsigneeCityName() {
		return eoorConsigneeCityName;
	}
	public void setEoorConsigneeCityName(String eoorConsigneeCityName) {
		this.eoorConsigneeCityName = eoorConsigneeCityName;
	}
	public String getEoorConsigneeDistrictCode() {
		return eoorConsigneeDistrictCode;
	}
	public void setEoorConsigneeDistrictCode(String eoorConsigneeDistrictCode) {
		this.eoorConsigneeDistrictCode = eoorConsigneeDistrictCode;
	}
	public String getEoorConsigneeDistrictName() {
		return eoorConsigneeDistrictName;
	}
	public void setEoorConsigneeDistrictName(String eoorConsigneeDistrictName) {
		this.eoorConsigneeDistrictName = eoorConsigneeDistrictName;
	}
	public String getEoorBarcode() {
		return eoorBarcode;
	}
	public void setEoorBarcode(String eoorBarcode) {
		this.eoorBarcode = eoorBarcode;
	}
	public String getEoorSourceCode() {
		return eoorSourceCode;
	}
	public void setEoorSourceCode(String eoorSourceCode) {
		this.eoorSourceCode = eoorSourceCode;
	}
	public String getEoorSourceName() {
		return eoorSourceName;
	}
	public void setEoorSourceName(String eoorSourceName) {
		this.eoorSourceName = eoorSourceName;
	}
	public Double getEoorPackageQuantity() {
		return eoorPackageQuantity;
	}
	public void setEoorPackageQuantity(Double eoorPackageQuantity) {
		this.eoorPackageQuantity = eoorPackageQuantity;
	}
	public Double getEoorQuantity() {
		return eoorQuantity;
	}
	public void setEoorQuantity(Double eoorQuantity) {
		this.eoorQuantity = eoorQuantity;
	}
	public Double getEoorGrossWeight() {
		return eoorGrossWeight;
	}
	public void setEoorGrossWeight(Double eoorGrossWeight) {
		this.eoorGrossWeight = eoorGrossWeight;
	}
	public Double getEoorNetWeight() {
		return eoorNetWeight;
	}
	public void setEoorNetWeight(Double eoorNetWeight) {
		this.eoorNetWeight = eoorNetWeight;
	}
	public Double getEoorVolume() {
		return eoorVolume;
	}
	public void setEoorVolume(Double eoorVolume) {
		this.eoorVolume = eoorVolume;
	}
	public String getEoorRequirement() {
		return eoorRequirement;
	}
	public void setEoorRequirement(String eoorRequirement) {
		this.eoorRequirement = eoorRequirement;
	}
	public String getEoorRemark() {
		return eoorRemark;
	}
	public void setEoorRemark(String eoorRemark) {
		this.eoorRemark = eoorRemark;
	}
	public String getEoorLinkOrderNo() {
		return eoorLinkOrderNo;
	}
	public void setEoorLinkOrderNo(String eoorLinkOrderNo) {
		this.eoorLinkOrderNo = eoorLinkOrderNo;
	}
	public String getEoorMegerFlag() {
		return eoorMegerFlag;
	}
	public void setEoorMegerFlag(String eoorMegerFlag) {
		this.eoorMegerFlag = eoorMegerFlag;
	}
	public Date getEoorExpirationTime() {
		return eoorExpirationTime;
	}
	public void setEoorExpirationTime(Date eoorExpirationTime) {
		this.eoorExpirationTime = eoorExpirationTime;
	}
	public String getEoorReservation() {
		return eoorReservation;
	}
	public void setEoorReservation(String eoorReservation) {
		this.eoorReservation = eoorReservation;
	}
	public String getEoorSalesmanCode() {
		return eoorSalesmanCode;
	}
	public void setEoorSalesmanCode(String eoorSalesmanCode) {
		this.eoorSalesmanCode = eoorSalesmanCode;
	}
	public String getEoorSalesmanName() {
		return eoorSalesmanName;
	}
	public void setEoorSalesmanName(String eoorSalesmanName) {
		this.eoorSalesmanName = eoorSalesmanName;
	}
	public String getEoorSplitFlag() {
		return eoorSplitFlag;
	}
	public void setEoorSplitFlag(String eoorSplitFlag) {
		this.eoorSplitFlag = eoorSplitFlag;
	}
	public String getEoorEmergentFlag() {
		return eoorEmergentFlag;
	}
	public void setEoorEmergentFlag(String eoorEmergentFlag) {
		this.eoorEmergentFlag = eoorEmergentFlag;
	}
	public String getEoorStatusColor() {
		return eoorStatusColor;
	}
	public void setEoorStatusColor(String eoorStatusColor) {
		this.eoorStatusColor = eoorStatusColor;
	}
	public String getEoorEventObjectCode() {
		return eoorEventObjectCode;
	}
	public void setEoorEventObjectCode(String eoorEventObjectCode) {
		this.eoorEventObjectCode = eoorEventObjectCode;
	}
	public String getEoorEventObjectName() {
		return eoorEventObjectName;
	}
	public void setEoorEventObjectName(String eoorEventObjectName) {
		this.eoorEventObjectName = eoorEventObjectName;
	}
	public String getEoorPaymentTypeCode() {
		return eoorPaymentTypeCode;
	}
	public void setEoorPaymentTypeCode(String eoorPaymentTypeCode) {
		this.eoorPaymentTypeCode = eoorPaymentTypeCode;
	}
	public String getEoorPaymentTypeName() {
		return eoorPaymentTypeName;
	}
	public void setEoorPaymentTypeName(String eoorPaymentTypeName) {
		this.eoorPaymentTypeName = eoorPaymentTypeName;
	}
	public String getEoorWarehouserCode() {
		return eoorWarehouserCode;
	}
	public void setEoorWarehouserCode(String eoorWarehouserCode) {
		this.eoorWarehouserCode = eoorWarehouserCode;
	}
	public String getEoorWarehouserName() {
		return eoorWarehouserName;
	}
	public void setEoorWarehouserName(String eoorWarehouserName) {
		this.eoorWarehouserName = eoorWarehouserName;
	}
	public String getEoorStationCode() {
		return eoorStationCode;
	}
	public void setEoorStationCode(String eoorStationCode) {
		this.eoorStationCode = eoorStationCode;
	}
	public String getEoorStationName() {
		return eoorStationName;
	}
	public void setEoorStationName(String eoorStationName) {
		this.eoorStationName = eoorStationName;
	}
	public String getEoorEditable() {
		return eoorEditable;
	}
	public void setEoorEditable(String eoorEditable) {
		this.eoorEditable = eoorEditable;
	}
	public Double getEoorAmount() {
		return eoorAmount;
	}
	public void setEoorAmount(Double eoorAmount) {
		this.eoorAmount = eoorAmount;
	}
	public String getEoorCollectionDelivery() {
		return eoorCollectionDelivery;
	}
	public void setEoorCollectionDelivery(String eoorCollectionDelivery) {
		this.eoorCollectionDelivery = eoorCollectionDelivery;
	}
	public Double getEoorCollectionAmount() {
		return eoorCollectionAmount;
	}
	public void setEoorCollectionAmount(Double eoorCollectionAmount) {
		this.eoorCollectionAmount = eoorCollectionAmount;
	}
	public String getEoorSellingCustomerCode() {
		return eoorSellingCustomerCode;
	}
	public void setEoorSellingCustomerCode(String eoorSellingCustomerCode) {
		this.eoorSellingCustomerCode = eoorSellingCustomerCode;
	}
	public String getEoorSellingCustomerName() {
		return eoorSellingCustomerName;
	}
	public void setEoorSellingCustomerName(String eoorSellingCustomerName) {
		this.eoorSellingCustomerName = eoorSellingCustomerName;
	}
	public String getEoorEventStatusCode() {
		return eoorEventStatusCode;
	}
	public void setEoorEventStatusCode(String eoorEventStatusCode) {
		this.eoorEventStatusCode = eoorEventStatusCode;
	}
	public String getEoorStatusRemark() {
		return eoorStatusRemark;
	}
	public void setEoorStatusRemark(String eoorStatusRemark) {
		this.eoorStatusRemark = eoorStatusRemark;
	}
	public String getEoorMainOrderNo() {
		return eoorMainOrderNo;
	}
	public void setEoorMainOrderNo(String eoorMainOrderNo) {
		this.eoorMainOrderNo = eoorMainOrderNo;
	}
	public String getEoorSpdNo() {
		return eoorSpdNo;
	}
	public void setEoorSpdNo(String eoorSpdNo) {
		this.eoorSpdNo = eoorSpdNo;
	}
	public String getEoorOpsNo() {
		return eoorOpsNo;
	}
	public void setEoorOpsNo(String eoorOpsNo) {
		this.eoorOpsNo = eoorOpsNo;
	}
	public String getEoorTransNo() {
		return eoorTransNo;
	}
	public void setEoorTransNo(String eoorTransNo) {
		this.eoorTransNo = eoorTransNo;
	}
	public String getEoorSecondTransNo() {
		return eoorSecondTransNo;
	}
	public void setEoorSecondTransNo(String eoorSecondTransNo) {
		this.eoorSecondTransNo = eoorSecondTransNo;
	}
	public Date getEoorCustomerOrderTime() {
		return eoorCustomerOrderTime;
	}
	public void setEoorCustomerOrderTime(Date eoorCustomerOrderTime) {
		this.eoorCustomerOrderTime = eoorCustomerOrderTime;
	}
	public Date getEoorSpdOrderTime() {
		return eoorSpdOrderTime;
	}
	public void setEoorSpdOrderTime(Date eoorSpdOrderTime) {
		this.eoorSpdOrderTime = eoorSpdOrderTime;
	}
	public Date getEoorRequireShipperTime() {
		return eoorRequireShipperTime;
	}
	public void setEoorRequireShipperTime(Date eoorRequireShipperTime) {
		this.eoorRequireShipperTime = eoorRequireShipperTime;
	}
	public Date getEoorRequireConsigneeTime() {
		return eoorRequireConsigneeTime;
	}
	public void setEoorRequireConsigneeTime(Date eoorRequireConsigneeTime) {
		this.eoorRequireConsigneeTime = eoorRequireConsigneeTime;
	}
	public String getEoorCarrierCode() {
		return eoorCarrierCode;
	}
	public void setEoorCarrierCode(String eoorCarrierCode) {
		this.eoorCarrierCode = eoorCarrierCode;
	}
	public String getEoorCarrierName() {
		return eoorCarrierName;
	}
	public void setEoorCarrierName(String eoorCarrierName) {
		this.eoorCarrierName = eoorCarrierName;
	}
	public String getEoorIntercepStatusCode() {
		return eoorIntercepStatusCode;
	}
	public void setEoorIntercepStatusCode(String eoorIntercepStatusCode) {
		this.eoorIntercepStatusCode = eoorIntercepStatusCode;
	}
	public String getEoorTransitHubCode() {
		return eoorTransitHubCode;
	}
	public void setEoorTransitHubCode(String eoorTransitHubCode) {
		this.eoorTransitHubCode = eoorTransitHubCode;
	}
	public String getEoorTransitHubName() {
		return eoorTransitHubName;
	}
	public void setEoorTransitHubName(String eoorTransitHubName) {
		this.eoorTransitHubName = eoorTransitHubName;
	}
	public String getEoorSupplierCode() {
		return eoorSupplierCode;
	}
	public void setEoorSupplierCode(String eoorSupplierCode) {
		this.eoorSupplierCode = eoorSupplierCode;
	}
	public String getEoorSupplierName() {
		return eoorSupplierName;
	}
	public void setEoorSupplierName(String eoorSupplierName) {
		this.eoorSupplierName = eoorSupplierName;
	}
	public String getEoorIsPositive() {
		return eoorIsPositive;
	}
	public void setEoorIsPositive(String eoorIsPositive) {
		this.eoorIsPositive = eoorIsPositive;
	}
	public String getEoorShipperProvinceCode() {
		return eoorShipperProvinceCode;
	}
	public void setEoorShipperProvinceCode(String eoorShipperProvinceCode) {
		this.eoorShipperProvinceCode = eoorShipperProvinceCode;
	}
	public String getEoorShipperProvinceName() {
		return eoorShipperProvinceName;
	}
	public void setEoorShipperProvinceName(String eoorShipperProvinceName) {
		this.eoorShipperProvinceName = eoorShipperProvinceName;
	}
	public String getEoorShipperAddress() {
		return eoorShipperAddress;
	}
	public void setEoorShipperAddress(String eoorShipperAddress) {
		this.eoorShipperAddress = eoorShipperAddress;
	}
	public String getEoorConsigneeContactTel() {
		return eoorConsigneeContactTel;
	}
	public void setEoorConsigneeContactTel(String eoorConsigneeContactTel) {
		this.eoorConsigneeContactTel = eoorConsigneeContactTel;
	}
	public String getEoorConsigneeProvinceCode() {
		return eoorConsigneeProvinceCode;
	}
	public void setEoorConsigneeProvinceCode(String eoorConsigneeProvinceCode) {
		this.eoorConsigneeProvinceCode = eoorConsigneeProvinceCode;
	}
	public String getEoorConsigneeProvinceName() {
		return eoorConsigneeProvinceName;
	}
	public void setEoorConsigneeProvinceName(String eoorConsigneeProvinceName) {
		this.eoorConsigneeProvinceName = eoorConsigneeProvinceName;
	}
	public String getEoorConsigneeStreetCode() {
		return eoorConsigneeStreetCode;
	}
	public void setEoorConsigneeStreetCode(String eoorConsigneeStreetCode) {
		this.eoorConsigneeStreetCode = eoorConsigneeStreetCode;
	}
	public String getEoorConsigneeStreetName() {
		return eoorConsigneeStreetName;
	}
	public void setEoorConsigneeStreetName(String eoorConsigneeStreetName) {
		this.eoorConsigneeStreetName = eoorConsigneeStreetName;
	}
	public String getEoorConsigneeAddress() {
		return eoorConsigneeAddress;
	}
	public void setEoorConsigneeAddress(String eoorConsigneeAddress) {
		this.eoorConsigneeAddress = eoorConsigneeAddress;
	}
	public String getEoorBuyerRemark() {
		return eoorBuyerRemark;
	}
	public void setEoorBuyerRemark(String eoorBuyerRemark) {
		this.eoorBuyerRemark = eoorBuyerRemark;
	}
	public String getEoorSellerRemark() {
		return eoorSellerRemark;
	}
	public void setEoorSellerRemark(String eoorSellerRemark) {
		this.eoorSellerRemark = eoorSellerRemark;
	}
	public String getEoorIsFreight() {
		return eoorIsFreight;
	}
	public void setEoorIsFreight(String eoorIsFreight) {
		this.eoorIsFreight = eoorIsFreight;
	}
	public Double getEoorPretreatmentTotalFee() {
		return eoorPretreatmentTotalFee;
	}
	public void setEoorPretreatmentTotalFee(Double eoorPretreatmentTotalFee) {
		this.eoorPretreatmentTotalFee = eoorPretreatmentTotalFee;
	}
	public Double getEoorCargoValue() {
		return eoorCargoValue;
	}
	public void setEoorCargoValue(Double eoorCargoValue) {
		this.eoorCargoValue = eoorCargoValue;
	}
	public String getEoorIsEqualPayment() {
		return eoorIsEqualPayment;
	}
	public void setEoorIsEqualPayment(String eoorIsEqualPayment) {
		this.eoorIsEqualPayment = eoorIsEqualPayment;
	}
	public String getEoorIsWaybill() {
		return eoorIsWaybill;
	}
	public void setEoorIsWaybill(String eoorIsWaybill) {
		this.eoorIsWaybill = eoorIsWaybill;
	}
	public String getEoorInvoiceRequest() {
		return eoorInvoiceRequest;
	}
	public void setEoorInvoiceRequest(String eoorInvoiceRequest) {
		this.eoorInvoiceRequest = eoorInvoiceRequest;
	}
	public String getEoorIsUpstair() {
		return eoorIsUpstair;
	}
	public void setEoorIsUpstair(String eoorIsUpstair) {
		this.eoorIsUpstair = eoorIsUpstair;
	}
	public String getEoorDelierySetupType() {
		return eoorDelierySetupType;
	}
	public void setEoorDelierySetupType(String eoorDelierySetupType) {
		this.eoorDelierySetupType = eoorDelierySetupType;
	}
	public Double getEoorTransTime() {
		return eoorTransTime;
	}
	public void setEoorTransTime(Double eoorTransTime) {
		this.eoorTransTime = eoorTransTime;
	}
	public String getEoorCustomServiceCode() {
		return eoorCustomServiceCode;
	}
	public void setEoorCustomServiceCode(String eoorCustomServiceCode) {
		this.eoorCustomServiceCode = eoorCustomServiceCode;
	}
	public String getEoorCustomServiceName() {
		return eoorCustomServiceName;
	}
	public void setEoorCustomServiceName(String eoorCustomServiceName) {
		this.eoorCustomServiceName = eoorCustomServiceName;
	}
	public String getEoorCustomServiceRemark() {
		return eoorCustomServiceRemark;
	}
	public void setEoorCustomServiceRemark(String eoorCustomServiceRemark) {
		this.eoorCustomServiceRemark = eoorCustomServiceRemark;
	}
	public String getEoorIsEmergency() {
		return eoorIsEmergency;
	}
	public void setEoorIsEmergency(String eoorIsEmergency) {
		this.eoorIsEmergency = eoorIsEmergency;
	}
	public String getEoorRejectReason() {
		return eoorRejectReason;
	}
	public void setEoorRejectReason(String eoorRejectReason) {
		this.eoorRejectReason = eoorRejectReason;
	}
	public Date getEoorRejectDate() {
		return eoorRejectDate;
	}
	public void setEoorRejectDate(Date eoorRejectDate) {
		this.eoorRejectDate = eoorRejectDate;
	}
	public String getEoorIsShipperAppoint() {
		return eoorIsShipperAppoint;
	}
	public void setEoorIsShipperAppoint(String eoorIsShipperAppoint) {
		this.eoorIsShipperAppoint = eoorIsShipperAppoint;
	}
	public Date getEoorShipperAppointDate() {
		return eoorShipperAppointDate;
	}
	public void setEoorShipperAppointDate(Date eoorShipperAppointDate) {
		this.eoorShipperAppointDate = eoorShipperAppointDate;
	}
	public String getEoorIsConsigneeAppoint() {
		return eoorIsConsigneeAppoint;
	}
	public void setEoorIsConsigneeAppoint(String eoorIsConsigneeAppoint) {
		this.eoorIsConsigneeAppoint = eoorIsConsigneeAppoint;
	}
	public Date getEoorConsigneeAppointDate() {
		return eoorConsigneeAppointDate;
	}
	public void setEoorConsigneeAppointDate(Date eoorConsigneeAppointDate) {
		this.eoorConsigneeAppointDate = eoorConsigneeAppointDate;
	}
	public String getEoorPayStatus() {
		return eoorPayStatus;
	}
	public void setEoorPayStatus(String eoorPayStatus) {
		this.eoorPayStatus = eoorPayStatus;
	}
	public String getEoorIsInvoice() {
		return eoorIsInvoice;
	}
	public void setEoorIsInvoice(String eoorIsInvoice) {
		this.eoorIsInvoice = eoorIsInvoice;
	}
	public String getEoorInvoiceType() {
		return eoorInvoiceType;
	}
	public void setEoorInvoiceType(String eoorInvoiceType) {
		this.eoorInvoiceType = eoorInvoiceType;
	}
	public String getEoorInvoiceTitle() {
		return eoorInvoiceTitle;
	}
	public void setEoorInvoiceTitle(String eoorInvoiceTitle) {
		this.eoorInvoiceTitle = eoorInvoiceTitle;
	}
	public String getEoorDeliveryType() {
		return eoorDeliveryType;
	}
	public void setEoorDeliveryType(String eoorDeliveryType) {
		this.eoorDeliveryType = eoorDeliveryType;
	}
	public String getEoorDeliveryDateType() {
		return eoorDeliveryDateType;
	}
	public void setEoorDeliveryDateType(String eoorDeliveryDateType) {
		this.eoorDeliveryDateType = eoorDeliveryDateType;
	}
	public String getEoorIsPod() {
		return eoorIsPod;
	}
	public void setEoorIsPod(String eoorIsPod) {
		this.eoorIsPod = eoorIsPod;
	}
	public String getEoorBusinessResult() {
		return eoorBusinessResult;
	}
	public void setEoorBusinessResult(String eoorBusinessResult) {
		this.eoorBusinessResult = eoorBusinessResult;
	}
	public String getEoorOriginalOpsNo() {
		return eoorOriginalOpsNo;
	}
	public void setEoorOriginalOpsNo(String eoorOriginalOpsNo) {
		this.eoorOriginalOpsNo = eoorOriginalOpsNo;
	}
	public String getEoorOriginalOrderNo() {
		return eoorOriginalOrderNo;
	}
	public void setEoorOriginalOrderNo(String eoorOriginalOrderNo) {
		this.eoorOriginalOrderNo = eoorOriginalOrderNo;
	}
	public Date getEoorOutboundTime() {
		return eoorOutboundTime;
	}
	public void setEoorOutboundTime(Date eoorOutboundTime) {
		this.eoorOutboundTime = eoorOutboundTime;
	}
	public Date getEoorHubReceiveTime() {
		return eoorHubReceiveTime;
	}
	public void setEoorHubReceiveTime(Date eoorHubReceiveTime) {
		this.eoorHubReceiveTime = eoorHubReceiveTime;
	}
	public Date getEoorPayTime() {
		return eoorPayTime;
	}
	public void setEoorPayTime(Date eoorPayTime) {
		this.eoorPayTime = eoorPayTime;
	}
	public Date getEoorFinanceApprovalTime() {
		return eoorFinanceApprovalTime;
	}
	public void setEoorFinanceApprovalTime(Date eoorFinanceApprovalTime) {
		this.eoorFinanceApprovalTime = eoorFinanceApprovalTime;
	}
	public String getEoorSpdWorkNo() {
		return eoorSpdWorkNo;
	}
	public void setEoorSpdWorkNo(String eoorSpdWorkNo) {
		this.eoorSpdWorkNo = eoorSpdWorkNo;
	}
	public String getEoorCargoPayType() {
		return eoorCargoPayType;
	}
	public void setEoorCargoPayType(String eoorCargoPayType) {
		this.eoorCargoPayType = eoorCargoPayType;
	}
	public Date getEoorInstallDate() {
		return eoorInstallDate;
	}
	public void setEoorInstallDate(Date eoorInstallDate) {
		this.eoorInstallDate = eoorInstallDate;
	}
	public String getEoorIsB2c() {
		return eoorIsB2c;
	}
	public void setEoorIsB2c(String eoorIsB2c) {
		this.eoorIsB2c = eoorIsB2c;
	}
	public String getEoorPackageRequire() {
		return eoorPackageRequire;
	}
	public void setEoorPackageRequire(String eoorPackageRequire) {
		this.eoorPackageRequire = eoorPackageRequire;
	}
	public String getEoorConsigneeContactIdCard() {
		return eoorConsigneeContactIdCard;
	}
	public void setEoorConsigneeContactIdCard(String eoorConsigneeContactIdCard) {
		this.eoorConsigneeContactIdCard = eoorConsigneeContactIdCard;
	}
	public Date getEoorLogisticsSendDate() {
		return eoorLogisticsSendDate;
	}
	public void setEoorLogisticsSendDate(Date eoorLogisticsSendDate) {
		this.eoorLogisticsSendDate = eoorLogisticsSendDate;
	}
	public Date getEoorLogisticsReceiveDate() {
		return eoorLogisticsReceiveDate;
	}
	public void setEoorLogisticsReceiveDate(Date eoorLogisticsReceiveDate) {
		this.eoorLogisticsReceiveDate = eoorLogisticsReceiveDate;
	}
	public String getEoorAdviseCarrierCode() {
		return eoorAdviseCarrierCode;
	}
	public void setEoorAdviseCarrierCode(String eoorAdviseCarrierCode) {
		this.eoorAdviseCarrierCode = eoorAdviseCarrierCode;
	}
	public String getEoorAdviseCarrierName() {
		return eoorAdviseCarrierName;
	}
	public void setEoorAdviseCarrierName(String eoorAdviseCarrierName) {
		this.eoorAdviseCarrierName = eoorAdviseCarrierName;
	}
	public String getEoorShipperStreetCode() {
		return eoorShipperStreetCode;
	}
	public void setEoorShipperStreetCode(String eoorShipperStreetCode) {
		this.eoorShipperStreetCode = eoorShipperStreetCode;
	}
	public String getEoorShipperStreetName() {
		return eoorShipperStreetName;
	}
	public void setEoorShipperStreetName(String eoorShipperStreetName) {
		this.eoorShipperStreetName = eoorShipperStreetName;
	}
	public String getEoorEdiSenderCode() {
		return eoorEdiSenderCode;
	}
	public void setEoorEdiSenderCode(String eoorEdiSenderCode) {
		this.eoorEdiSenderCode = eoorEdiSenderCode;
	}
	public String getEoorFactCarrierCode() {
		return eoorFactCarrierCode;
	}
	public void setEoorFactCarrierCode(String eoorFactCarrierCode) {
		this.eoorFactCarrierCode = eoorFactCarrierCode;
	}
	public String getEoorFactCarrierName() {
		return eoorFactCarrierName;
	}
	public void setEoorFactCarrierName(String eoorFactCarrierName) {
		this.eoorFactCarrierName = eoorFactCarrierName;
	}
	public String getEoorShipperContactTel() {
		return eoorShipperContactTel;
	}
	public void setEoorShipperContactTel(String eoorShipperContactTel) {
		this.eoorShipperContactTel = eoorShipperContactTel;
	}
	public String getEoorOrigPlaceCode() {
		return eoorOrigPlaceCode;
	}
	public void setEoorOrigPlaceCode(String eoorOrigPlaceCode) {
		this.eoorOrigPlaceCode = eoorOrigPlaceCode;
	}
	public String getEoorDescPlaceCode() {
		return eoorDescPlaceCode;
	}
	public void setEoorDescPlaceCode(String eoorDescPlaceCode) {
		this.eoorDescPlaceCode = eoorDescPlaceCode;
	}
	public String getEoorStoreName() {
		return eoorStoreName;
	}
	public void setEoorStoreName(String eoorStoreName) {
		this.eoorStoreName = eoorStoreName;
	}
	public String getEoorExceptionStatus() {
		return eoorExceptionStatus;
	}
	public void setEoorExceptionStatus(String eoorExceptionStatus) {
		this.eoorExceptionStatus = eoorExceptionStatus;
	}
	public String getEoorIsCountFee() {
		return eoorIsCountFee;
	}
	public void setEoorIsCountFee(String eoorIsCountFee) {
		this.eoorIsCountFee = eoorIsCountFee;
	}
	public Double getEoorWeightVolume() {
		return eoorWeightVolume;
	}
	public void setEoorWeightVolume(Double eoorWeightVolume) {
		this.eoorWeightVolume = eoorWeightVolume;
	}
	public String getEoorCustomerType() {
		return eoorCustomerType;
	}
	public void setEoorCustomerType(String eoorCustomerType) {
		this.eoorCustomerType = eoorCustomerType;
	}
	public String getEoorSubscriber() {
		return eoorSubscriber;
	}
	public void setEoorSubscriber(String eoorSubscriber) {
		this.eoorSubscriber = eoorSubscriber;
	}
	public String getEoorWaveCode() {
		return eoorWaveCode;
	}
	public void setEoorWaveCode(String eoorWaveCode) {
		this.eoorWaveCode = eoorWaveCode;
	}
	public String getEoorSaleCode() {
		return eoorSaleCode;
	}
	public void setEoorSaleCode(String eoorSaleCode) {
		this.eoorSaleCode = eoorSaleCode;
	}
	public String getEoorShortCode() {
		return eoorShortCode;
	}
	public void setEoorShortCode(String eoorShortCode) {
		this.eoorShortCode = eoorShortCode;
	}
	public Double getEoorOriginalQty() {
		return eoorOriginalQty;
	}
	public void setEoorOriginalQty(Double eoorOriginalQty) {
		this.eoorOriginalQty = eoorOriginalQty;
	}
	public String getEoorIsAllIntercept() {
		return eoorIsAllIntercept;
	}
	public void setEoorIsAllIntercept(String eoorIsAllIntercept) {
		this.eoorIsAllIntercept = eoorIsAllIntercept;
	}
	public String getEoorIsTransport() {
		return eoorIsTransport;
	}
	public void setEoorIsTransport(String eoorIsTransport) {
		this.eoorIsTransport = eoorIsTransport;
	}
	public String getEoorIsStorckOut() {
		return eoorIsStorckOut;
	}
	public void setEoorIsStorckOut(String eoorIsStorckOut) {
		this.eoorIsStorckOut = eoorIsStorckOut;
	}
	public String getEoorIsStorckIn() {
		return eoorIsStorckIn;
	}
	public void setEoorIsStorckIn(String eoorIsStorckIn) {
		this.eoorIsStorckIn = eoorIsStorckIn;
	}
	public String getEoorPointCode() {
		return eoorPointCode;
	}
	public void setEoorPointCode(String eoorPointCode) {
		this.eoorPointCode = eoorPointCode;
	}
	public String getEoorPointName() {
		return eoorPointName;
	}
	public void setEoorPointName(String eoorPointName) {
		this.eoorPointName = eoorPointName;
	}
	public String getEoorIsSendSpd() {
		return eoorIsSendSpd;
	}
	public void setEoorIsSendSpd(String eoorIsSendSpd) {
		this.eoorIsSendSpd = eoorIsSendSpd;
	}
	public String getEoorHasLine() {
		return eoorHasLine;
	}
	public void setEoorHasLine(String eoorHasLine) {
		this.eoorHasLine = eoorHasLine;
	}
	public String getEoorSequence() {
		return eoorSequence;
	}
	public void setEoorSequence(String eoorSequence) {
		this.eoorSequence = eoorSequence;
	}
	public Double getEoorWaveTotal() {
		return eoorWaveTotal;
	}
	public void setEoorWaveTotal(Double eoorWaveTotal) {
		this.eoorWaveTotal = eoorWaveTotal;
	}
	public String getEoorIsWaveSync() {
		return eoorIsWaveSync;
	}
	public void setEoorIsWaveSync(String eoorIsWaveSync) {
		this.eoorIsWaveSync = eoorIsWaveSync;
	}
	public Date getEoorCustomerApprovalTime() {
		return eoorCustomerApprovalTime;
	}
	public void setEoorCustomerApprovalTime(Date eoorCustomerApprovalTime) {
		this.eoorCustomerApprovalTime = eoorCustomerApprovalTime;
	}
	public Date getEoorBusinessApprovalTime() {
		return eoorBusinessApprovalTime;
	}
	public void setEoorBusinessApprovalTime(Date eoorBusinessApprovalTime) {
		this.eoorBusinessApprovalTime = eoorBusinessApprovalTime;
	}
	public Date getEoorFactOutboundTime() {
		return eoorFactOutboundTime;
	}
	public void setEoorFactOutboundTime(Date eoorFactOutboundTime) {
		this.eoorFactOutboundTime = eoorFactOutboundTime;
	}
	public Date getEoorPickingGoods() {
		return eoorPickingGoods;
	}
	public void setEoorPickingGoods(Date eoorPickingGoods) {
		this.eoorPickingGoods = eoorPickingGoods;
	}
	public Date getEoorConfirmReturnTime() {
		return eoorConfirmReturnTime;
	}
	public void setEoorConfirmReturnTime(Date eoorConfirmReturnTime) {
		this.eoorConfirmReturnTime = eoorConfirmReturnTime;
	}
	public String getEoorIsJlp() {
		return eoorIsJlp;
	}
	public void setEoorIsJlp(String eoorIsJlp) {
		this.eoorIsJlp = eoorIsJlp;
	}
	public Date getEoorStorckIn() {
		return eoorStorckIn;
	}
	public void setEoorStorckIn(Date eoorStorckIn) {
		this.eoorStorckIn = eoorStorckIn;
	}
	public String getEoorIsSyncTaxPrinter() {
		return eoorIsSyncTaxPrinter;
	}
	public void setEoorIsSyncTaxPrinter(String eoorIsSyncTaxPrinter) {
		this.eoorIsSyncTaxPrinter = eoorIsSyncTaxPrinter;
	}
	public String getEoorTransChange() {
		return eoorTransChange;
	}
	public void setEoorTransChange(String eoorTransChange) {
		this.eoorTransChange = eoorTransChange;
	}
	public String getEoorIsPrint() {
		return eoorIsPrint;
	}
	public void setEoorIsPrint(String eoorIsPrint) {
		this.eoorIsPrint = eoorIsPrint;
	}
	public Long getEoorPrintCount() {
		return eoorPrintCount;
	}
	public void setEoorPrintCount(Long eoorPrintCount) {
		this.eoorPrintCount = eoorPrintCount;
	}
	public Date getEoorWaveTime() {
		return eoorWaveTime;
	}
	public void setEoorWaveTime(Date eoorWaveTime) {
		this.eoorWaveTime = eoorWaveTime;
	}
	public Date getEoorKeyinTime() {
		return eoorKeyinTime;
	}
	public void setEoorKeyinTime(Date eoorKeyinTime) {
		this.eoorKeyinTime = eoorKeyinTime;
	}
	public String getEoorTransParty() {
		return eoorTransParty;
	}
	public void setEoorTransParty(String eoorTransParty) {
		this.eoorTransParty = eoorTransParty;
	}
	public String getEoorSpdLogisticNo() {
		return eoorSpdLogisticNo;
	}
	public void setEoorSpdLogisticNo(String eoorSpdLogisticNo) {
		this.eoorSpdLogisticNo = eoorSpdLogisticNo;
	}
	public Date getEoorCountFeeTime() {
		return eoorCountFeeTime;
	}
	public void setEoorCountFeeTime(Date eoorCountFeeTime) {
		this.eoorCountFeeTime = eoorCountFeeTime;
	}
	public String getEoorExecuteStatus() {
		return eoorExecuteStatus;
	}
	public void setEoorExecuteStatus(String eoorExecuteStatus) {
		this.eoorExecuteStatus = eoorExecuteStatus;
	}
	public String getEoorFaFlag() {
		return eoorFaFlag;
	}
	public void setEoorFaFlag(String eoorFaFlag) {
		this.eoorFaFlag = eoorFaFlag;
	}
	public String getEoorInventoryWhCode() {
		return eoorInventoryWhCode;
	}
	public void setEoorInventoryWhCode(String eoorInventoryWhCode) {
		this.eoorInventoryWhCode = eoorInventoryWhCode;
	}
	public String getEoorInventoryWhName() {
		return eoorInventoryWhName;
	}
	public void setEoorInventoryWhName(String eoorInventoryWhName) {
		this.eoorInventoryWhName = eoorInventoryWhName;
	}
	public String getEsstCode() {
		return esstCode;
	}
	public void setEsstCode(String esstCode) {
		this.esstCode = esstCode;
	}
	public String getEsstName() {
		return esstName;
	}
	public void setEsstName(String esstName) {
		this.esstName = esstName;
	}
	public String getEoorPropertyOwnerCode() {
		return eoorPropertyOwnerCode;
	}
	public void setEoorPropertyOwnerCode(String eoorPropertyOwnerCode) {
		this.eoorPropertyOwnerCode = eoorPropertyOwnerCode;
	}
	public String getEoorPropertyOwner() {
		return eoorPropertyOwner;
	}
	public void setEoorPropertyOwner(String eoorPropertyOwner) {
		this.eoorPropertyOwner = eoorPropertyOwner;
	}
	public String getEoorPlatformCode() {
		return eoorPlatformCode;
	}
	public void setEoorPlatformCode(String eoorPlatformCode) {
		this.eoorPlatformCode = eoorPlatformCode;
	}
	public String getEoorPromtionType() {
		return eoorPromtionType;
	}
	public void setEoorPromtionType(String eoorPromtionType) {
		this.eoorPromtionType = eoorPromtionType;
	}
	public String getEoorLine() {
		return eoorLine;
	}
	public void setEoorLine(String eoorLine) {
		this.eoorLine = eoorLine;
	}
	public Double getEoorMileage() {
		return eoorMileage;
	}
	public void setEoorMileage(Double eoorMileage) {
		this.eoorMileage = eoorMileage;
	}
	public String getEoorChargeAgainstReason() {
		return eoorChargeAgainstReason;
	}
	public void setEoorChargeAgainstReason(String eoorChargeAgainstReason) {
		this.eoorChargeAgainstReason = eoorChargeAgainstReason;
	}
	public Date getEoorBuyerOrderTime() {
		return eoorBuyerOrderTime;
	}
	public void setEoorBuyerOrderTime(Date eoorBuyerOrderTime) {
		this.eoorBuyerOrderTime = eoorBuyerOrderTime;
	}
	public Date getEoorShipperBookingDateFrom() {
		return eoorShipperBookingDateFrom;
	}
	public void setEoorShipperBookingDateFrom(Date eoorShipperBookingDateFrom) {
		this.eoorShipperBookingDateFrom = eoorShipperBookingDateFrom;
	}
	public Date getEoorShipperBookingDateTo() {
		return eoorShipperBookingDateTo;
	}
	public void setEoorShipperBookingDateTo(Date eoorShipperBookingDateTo) {
		this.eoorShipperBookingDateTo = eoorShipperBookingDateTo;
	}
	public String getEoorPaymentWay() {
		return eoorPaymentWay;
	}
	public void setEoorPaymentWay(String eoorPaymentWay) {
		this.eoorPaymentWay = eoorPaymentWay;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getEoorShipperVillageName() {
		return eoorShipperVillageName;
	}
	public void setEoorShipperVillageName(String eoorShipperVillageName) {
		this.eoorShipperVillageName = eoorShipperVillageName;
	}
	public String getEoorShipperVillageCode() {
		return eoorShipperVillageCode;
	}
	public void setEoorShipperVillageCode(String eoorShipperVillageCode) {
		this.eoorShipperVillageCode = eoorShipperVillageCode;
	}
	public String getEoorConsigneeVillageName() {
		return eoorConsigneeVillageName;
	}
	public void setEoorConsigneeVillageName(String eoorConsigneeVillageName) {
		this.eoorConsigneeVillageName = eoorConsigneeVillageName;
	}
	public String getEoorConsigneeVillageCode() {
		return eoorConsigneeVillageCode;
	}
	public void setEoorConsigneeVillageCode(String eoorConsigneeVillageCode) {
		this.eoorConsigneeVillageCode = eoorConsigneeVillageCode;
	}
	public String getEoorReservationStatus() {
		return eoorReservationStatus;
	}
	public void setEoorReservationStatus(String eoorReservationStatus) {
		this.eoorReservationStatus = eoorReservationStatus;
	}
	public Date getEoorReservationArrivalTime() {
		return eoorReservationArrivalTime;
	}
	public void setEoorReservationArrivalTime(Date eoorReservationArrivalTime) {
		this.eoorReservationArrivalTime = eoorReservationArrivalTime;
	}
	public Date getEoorExcpeptTime() {
		return eoorExcpeptTime;
	}
	public void setEoorExcpeptTime(Date eoorExcpeptTime) {
		this.eoorExcpeptTime = eoorExcpeptTime;
	}
	public Date getEoorReservationTime() {
		return eoorReservationTime;
	}
	public void setEoorReservationTime(Date eoorReservationTime) {
		this.eoorReservationTime = eoorReservationTime;
	}
	public Date getEoorReservationIssueTime() {
		return eoorReservationIssueTime;
	}
	public void setEoorReservationIssueTime(Date eoorReservationIssueTime) {
		this.eoorReservationIssueTime = eoorReservationIssueTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Long getEoorIsCollectionAmount() {
		return eoorIsCollectionAmount;
	}
	public void setEoorIsCollectionAmount(Long eoorIsCollectionAmount) {
		this.eoorIsCollectionAmount = eoorIsCollectionAmount;
	}
	public Long getEoorIsTakeDeliveryHoliday() {
		return eoorIsTakeDeliveryHoliday;
	}
	public void setEoorIsTakeDeliveryHoliday(Long eoorIsTakeDeliveryHoliday) {
		this.eoorIsTakeDeliveryHoliday = eoorIsTakeDeliveryHoliday;
	}
	public String getEoorReturnGoodsReason() {
		return eoorReturnGoodsReason;
	}
	public void setEoorReturnGoodsReason(String eoorReturnGoodsReason) {
		this.eoorReturnGoodsReason = eoorReturnGoodsReason;
	}
	public Long getEoorParseStatus() {
		return eoorParseStatus;
	}
	public void setEoorParseStatus(Long eoorParseStatus) {
		this.eoorParseStatus = eoorParseStatus;
	}
	public String getEoorParseArea() {
		return eoorParseArea;
	}
	public void setEoorParseArea(String eoorParseArea) {
		this.eoorParseArea = eoorParseArea;
	}
	public String getEoorParseNetpoint() {
		return eoorParseNetpoint;
	}
	public void setEoorParseNetpoint(String eoorParseNetpoint) {
		this.eoorParseNetpoint = eoorParseNetpoint;
	}
	public String getEoorConsigneeWarehouserCode() {
		return eoorConsigneeWarehouserCode;
	}
	public void setEoorConsigneeWarehouserCode(String eoorConsigneeWarehouserCode) {
		this.eoorConsigneeWarehouserCode = eoorConsigneeWarehouserCode;
	}
	public String getEoorConsigneeWarehouserName() {
		return eoorConsigneeWarehouserName;
	}
	public void setEoorConsigneeWarehouserName(String eoorConsigneeWarehouserName) {
		this.eoorConsigneeWarehouserName = eoorConsigneeWarehouserName;
	}
	public String getEoorReturnFlag() {
		return eoorReturnFlag;
	}
	public void setEoorReturnFlag(String eoorReturnFlag) {
		this.eoorReturnFlag = eoorReturnFlag;
	}
	public Double getEoorDiscountAmount() {
		return eoorDiscountAmount;
	}
	public void setEoorDiscountAmount(Double eoorDiscountAmount) {
		this.eoorDiscountAmount = eoorDiscountAmount;
	}
	public Double getEoorPaymentAmount() {
		return eoorPaymentAmount;
	}
	public void setEoorPaymentAmount(Double eoorPaymentAmount) {
		this.eoorPaymentAmount = eoorPaymentAmount;
	}
	public String getEoorEosmPmCode() {
		return eoorEosmPmCode;
	}
	public void setEoorEosmPmCode(String eoorEosmPmCode) {
		this.eoorEosmPmCode = eoorEosmPmCode;
	}
	public Double getEoorInvoiceAmount() {
		return eoorInvoiceAmount;
	}
	public void setEoorInvoiceAmount(Double eoorInvoiceAmount) {
		this.eoorInvoiceAmount = eoorInvoiceAmount;
	}
	public String getEoorExpressNo() {
		return eoorExpressNo;
	}
	public void setEoorExpressNo(String eoorExpressNo) {
		this.eoorExpressNo = eoorExpressNo;
	}
	public Date getEoorExceptIssueTime() {
		return eoorExceptIssueTime;
	}
	public void setEoorExceptIssueTime(Date eoorExceptIssueTime) {
		this.eoorExceptIssueTime = eoorExceptIssueTime;
	}
	public String getEoorEblpCode() {
		return eoorEblpCode;
	}
	public void setEoorEblpCode(String eoorEblpCode) {
		this.eoorEblpCode = eoorEblpCode;
	}
	public String getEoorEblpName() {
		return eoorEblpName;
	}
	public void setEoorEblpName(String eoorEblpName) {
		this.eoorEblpName = eoorEblpName;
	}
	public String getEoorShipperLongitude() {
		return eoorShipperLongitude;
	}
	public void setEoorShipperLongitude(String eoorShipperLongitude) {
		this.eoorShipperLongitude = eoorShipperLongitude;
	}
	public String getEoorShipperLatitude() {
		return eoorShipperLatitude;
	}
	public void setEoorShipperLatitude(String eoorShipperLatitude) {
		this.eoorShipperLatitude = eoorShipperLatitude;
	}
	public String getEoorConsigneeLongitude() {
		return eoorConsigneeLongitude;
	}
	public void setEoorConsigneeLongitude(String eoorConsigneeLongitude) {
		this.eoorConsigneeLongitude = eoorConsigneeLongitude;
	}
	public String getEoorConsigneeLatitude() {
		return eoorConsigneeLatitude;
	}
	public void setEoorConsigneeLatitude(String eoorConsigneeLatitude) {
		this.eoorConsigneeLatitude = eoorConsigneeLatitude;
	}
	public String getEoorLongitude() {
		return eoorLongitude;
	}
	public void setEoorLongitude(String eoorLongitude) {
		this.eoorLongitude = eoorLongitude;
	}
	public String getEoorLatitude() {
		return eoorLatitude;
	}
	public void setEoorLatitude(String eoorLatitude) {
		this.eoorLatitude = eoorLatitude;
	}
	public Date getEoorBookArrivalTimeTo() {
		return eoorBookArrivalTimeTo;
	}
	public void setEoorBookArrivalTimeTo(Date eoorBookArrivalTimeTo) {
		this.eoorBookArrivalTimeTo = eoorBookArrivalTimeTo;
	}
	public String getEoorSpecCarrier() {
		return eoorSpecCarrier;
	}
	public void setEoorSpecCarrier(String eoorSpecCarrier) {
		this.eoorSpecCarrier = eoorSpecCarrier;
	}
	public String getEoorIsOutsource() {
		return eoorIsOutsource;
	}
	public void setEoorIsOutsource(String eoorIsOutsource) {
		this.eoorIsOutsource = eoorIsOutsource;
	}
	public String getEoorPackageItems() {
		return eoorPackageItems;
	}
	public void setEoorPackageItems(String eoorPackageItems) {
		this.eoorPackageItems = eoorPackageItems;
	}
	public String getEoorTransitHubType() {
		return eoorTransitHubType;
	}
	public void setEoorTransitHubType(String eoorTransitHubType) {
		this.eoorTransitHubType = eoorTransitHubType;
	}
	public Date getEoorFactInboundTime() {
		return eoorFactInboundTime;
	}
	public void setEoorFactInboundTime(Date eoorFactInboundTime) {
		this.eoorFactInboundTime = eoorFactInboundTime;
	}
	public String getEoorIsInstall() {
		return eoorIsInstall;
	}
	public void setEoorIsInstall(String eoorIsInstall) {
		this.eoorIsInstall = eoorIsInstall;
	}
	public Date getEoorSalesDate() {
		return eoorSalesDate;
	}
	public void setEoorSalesDate(Date eoorSalesDate) {
		this.eoorSalesDate = eoorSalesDate;
	}
	public String getEoorChannel() {
		return eoorChannel;
	}
	public void setEoorChannel(String eoorChannel) {
		this.eoorChannel = eoorChannel;
	}
	public String getEoorBusinessUnits() {
		return eoorBusinessUnits;
	}
	public void setEoorBusinessUnits(String eoorBusinessUnits) {
		this.eoorBusinessUnits = eoorBusinessUnits;
	}
	public String getEoorBusinessUnitsInfo() {
		return eoorBusinessUnitsInfo;
	}
	public void setEoorBusinessUnitsInfo(String eoorBusinessUnitsInfo) {
		this.eoorBusinessUnitsInfo = eoorBusinessUnitsInfo;
	}
	public String getEoorAbstract() {
		return eoorAbstract;
	}
	public void setEoorAbstract(String eoorAbstract) {
		this.eoorAbstract = eoorAbstract;
	}
	public String getEoorOtherInstructions() {
		return eoorOtherInstructions;
	}
	public void setEoorOtherInstructions(String eoorOtherInstructions) {
		this.eoorOtherInstructions = eoorOtherInstructions;
	}
	public String getEoorSaleChannel() {
		return eoorSaleChannel;
	}
	public void setEoorSaleChannel(String eoorSaleChannel) {
		this.eoorSaleChannel = eoorSaleChannel;
	}
	public String getEoorSaleman() {
		return eoorSaleman;
	}
	public void setEoorSaleman(String eoorSaleman) {
		this.eoorSaleman = eoorSaleman;
	}
	public String getEoorIsLift() {
		return eoorIsLift;
	}
	public void setEoorIsLift(String eoorIsLift) {
		this.eoorIsLift = eoorIsLift;
	}
	public Double getEoorServiceFee() {
		return eoorServiceFee;
	}
	public void setEoorServiceFee(Double eoorServiceFee) {
		this.eoorServiceFee = eoorServiceFee;
	}
	public String getEoorReceiverZip() {
		return eoorReceiverZip;
	}
	public void setEoorReceiverZip(String eoorReceiverZip) {
		this.eoorReceiverZip = eoorReceiverZip;
	}
	public String getEoorSenderZip() {
		return eoorSenderZip;
	}
	public void setEoorSenderZip(String eoorSenderZip) {
		this.eoorSenderZip = eoorSenderZip;
	}
	public Long getEoorFloor() {
		return eoorFloor;
	}
	public void setEoorFloor(Long eoorFloor) {
		this.eoorFloor = eoorFloor;
	}
	public String getEoorTransNoCn() {
		return eoorTransNoCn;
	}
	public void setEoorTransNoCn(String eoorTransNoCn) {
		this.eoorTransNoCn = eoorTransNoCn;
	}
	public String getEoorWorkType() {
		return eoorWorkType;
	}
	public void setEoorWorkType(String eoorWorkType) {
		this.eoorWorkType = eoorWorkType;
	}
	public Long getEoorServiceCount() {
		return eoorServiceCount;
	}
	public void setEoorServiceCount(Long eoorServiceCount) {
		this.eoorServiceCount = eoorServiceCount;
	}
	public String getEoorBuyerMail() {
		return eoorBuyerMail;
	}
	public void setEoorBuyerMail(String eoorBuyerMail) {
		this.eoorBuyerMail = eoorBuyerMail;
	}
	public String getEoorContractId() {
		return eoorContractId;
	}
	public void setEoorContractId(String eoorContractId) {
		this.eoorContractId = eoorContractId;
	}
	public String getEoorName() {
		return eoorName;
	}
	public void setEoorName(String eoorName) {
		this.eoorName = eoorName;
	}
	public Long getEoorReceiveTimeNumber() {
		return eoorReceiveTimeNumber;
	}
	public void setEoorReceiveTimeNumber(Long eoorReceiveTimeNumber) {
		this.eoorReceiveTimeNumber = eoorReceiveTimeNumber;
	}
	public Date getEoorExpireDate() {
		return eoorExpireDate;
	}
	public void setEoorExpireDate(Date eoorExpireDate) {
		this.eoorExpireDate = eoorExpireDate;
	}
	public String getEoorRefuseReason() {
		return eoorRefuseReason;
	}
	public void setEoorRefuseReason(String eoorRefuseReason) {
		this.eoorRefuseReason = eoorRefuseReason;
	}
	public String getEoorServiceTypeCode() {
		return eoorServiceTypeCode;
	}
	public void setEoorServiceTypeCode(String eoorServiceTypeCode) {
		this.eoorServiceTypeCode = eoorServiceTypeCode;
	}
	public String getEoorPayTypeCode() {
		return eoorPayTypeCode;
	}
	public void setEoorPayTypeCode(String eoorPayTypeCode) {
		this.eoorPayTypeCode = eoorPayTypeCode;
	}
	public String getEoorDeliveryTypeCode() {
		return eoorDeliveryTypeCode;
	}
	public void setEoorDeliveryTypeCode(String eoorDeliveryTypeCode) {
		this.eoorDeliveryTypeCode = eoorDeliveryTypeCode;
	}
	public String getEoorBackSignBillCode() {
		return eoorBackSignBillCode;
	}
	public void setEoorBackSignBillCode(String eoorBackSignBillCode) {
		this.eoorBackSignBillCode = eoorBackSignBillCode;
	}
	public String getEoorIsDirectSend() {
		return eoorIsDirectSend;
	}
	public void setEoorIsDirectSend(String eoorIsDirectSend) {
		this.eoorIsDirectSend = eoorIsDirectSend;
	}
	public Date getEoorSaleTime() {
		return eoorSaleTime;
	}
	public void setEoorSaleTime(Date eoorSaleTime) {
		this.eoorSaleTime = eoorSaleTime;
	}
	public String getEoorSalemanContact() {
		return eoorSalemanContact;
	}
	public void setEoorSalemanContact(String eoorSalemanContact) {
		this.eoorSalemanContact = eoorSalemanContact;
	}
	public String getEoorIsReceipt() {
		return eoorIsReceipt;
	}
	public void setEoorIsReceipt(String eoorIsReceipt) {
		this.eoorIsReceipt = eoorIsReceipt;
	}
	public String getEoorCostApply() {
		return eoorCostApply;
	}
	public void setEoorCostApply(String eoorCostApply) {
		this.eoorCostApply = eoorCostApply;
	}
	public String getEoorNoNeedInstallOperator() {
		return eoorNoNeedInstallOperator;
	}
	public void setEoorNoNeedInstallOperator(String eoorNoNeedInstallOperator) {
		this.eoorNoNeedInstallOperator = eoorNoNeedInstallOperator;
	}
	public Date getEoorNoNeedInstallDate() {
		return eoorNoNeedInstallDate;
	}
	public void setEoorNoNeedInstallDate(Date eoorNoNeedInstallDate) {
		this.eoorNoNeedInstallDate = eoorNoNeedInstallDate;
	}
	public String getEoorNoNeedInstallReason() {
		return eoorNoNeedInstallReason;
	}
	public void setEoorNoNeedInstallReason(String eoorNoNeedInstallReason) {
		this.eoorNoNeedInstallReason = eoorNoNeedInstallReason;
	}
	public String getEoorNoNeedInstallStatus() {
		return eoorNoNeedInstallStatus;
	}
	public void setEoorNoNeedInstallStatus(String eoorNoNeedInstallStatus) {
		this.eoorNoNeedInstallStatus = eoorNoNeedInstallStatus;
	}
	public String getEoorNoNeedInstallReasult() {
		return eoorNoNeedInstallReasult;
	}
	public void setEoorNoNeedInstallReasult(String eoorNoNeedInstallReasult) {
		this.eoorNoNeedInstallReasult = eoorNoNeedInstallReasult;
	}
	public String getEoorDeliverAreaCode() {
		return eoorDeliverAreaCode;
	}
	public void setEoorDeliverAreaCode(String eoorDeliverAreaCode) {
		this.eoorDeliverAreaCode = eoorDeliverAreaCode;
	}
	public String getEoorIsMaintenancePeriod() {
		return eoorIsMaintenancePeriod;
	}
	public void setEoorIsMaintenancePeriod(String eoorIsMaintenancePeriod) {
		this.eoorIsMaintenancePeriod = eoorIsMaintenancePeriod;
	}
	public String getEoorIsTemporary() {
		return eoorIsTemporary;
	}
	public void setEoorIsTemporary(String eoorIsTemporary) {
		this.eoorIsTemporary = eoorIsTemporary;
	}
	public String getEoorTemporaryExplain() {
		return eoorTemporaryExplain;
	}
	public void setEoorTemporaryExplain(String eoorTemporaryExplain) {
		this.eoorTemporaryExplain = eoorTemporaryExplain;
	}
	public String getEoorRookieType() {
		return eoorRookieType;
	}
	public void setEoorRookieType(String eoorRookieType) {
		this.eoorRookieType = eoorRookieType;
	}
	public String getEoorRookieStatus() {
		return eoorRookieStatus;
	}
	public void setEoorRookieStatus(String eoorRookieStatus) {
		this.eoorRookieStatus = eoorRookieStatus;
	}
	public String getEoorShipperContactCompany() {
		return eoorShipperContactCompany;
	}
	public void setEoorShipperContactCompany(String eoorShipperContactCompany) {
		this.eoorShipperContactCompany = eoorShipperContactCompany;
	}
	public String getEoorSenderCountry() {
		return eoorSenderCountry;
	}
	public void setEoorSenderCountry(String eoorSenderCountry) {
		this.eoorSenderCountry = eoorSenderCountry;
	}
	public String getEoorShipperExtendfileds() {
		return eoorShipperExtendfileds;
	}
	public void setEoorShipperExtendfileds(String eoorShipperExtendfileds) {
		this.eoorShipperExtendfileds = eoorShipperExtendfileds;
	}
	public String getEoorConsigneeContactCompany() {
		return eoorConsigneeContactCompany;
	}
	public void setEoorConsigneeContactCompany(String eoorConsigneeContactCompany) {
		this.eoorConsigneeContactCompany = eoorConsigneeContactCompany;
	}
	public String getEoorConsigneeContactWw() {
		return eoorConsigneeContactWw;
	}
	public void setEoorConsigneeContactWw(String eoorConsigneeContactWw) {
		this.eoorConsigneeContactWw = eoorConsigneeContactWw;
	}
	public String getEoorConsigneeContactCountry() {
		return eoorConsigneeContactCountry;
	}
	public void setEoorConsigneeContactCountry(String eoorConsigneeContactCountry) {
		this.eoorConsigneeContactCountry = eoorConsigneeContactCountry;
	}
	public String getEoorConsigneeExtendfileds() {
		return eoorConsigneeExtendfileds;
	}
	public void setEoorConsigneeExtendfileds(String eoorConsigneeExtendfileds) {
		this.eoorConsigneeExtendfileds = eoorConsigneeExtendfileds;
	}
	public String getEoorCarrierType() {
		return eoorCarrierType;
	}
	public void setEoorCarrierType(String eoorCarrierType) {
		this.eoorCarrierType = eoorCarrierType;
	}
	public String getEoorCarrierAddress() {
		return eoorCarrierAddress;
	}
	public void setEoorCarrierAddress(String eoorCarrierAddress) {
		this.eoorCarrierAddress = eoorCarrierAddress;
	}
	public String getEoorCarrierExtendfileds() {
		return eoorCarrierExtendfileds;
	}
	public void setEoorCarrierExtendfileds(String eoorCarrierExtendfileds) {
		this.eoorCarrierExtendfileds = eoorCarrierExtendfileds;
	}
	public String getEoorCarrierRemark() {
		return eoorCarrierRemark;
	}
	public void setEoorCarrierRemark(String eoorCarrierRemark) {
		this.eoorCarrierRemark = eoorCarrierRemark;
	}
	public String getEoorUpsysFormerNo() {
		return eoorUpsysFormerNo;
	}
	public void setEoorUpsysFormerNo(String eoorUpsysFormerNo) {
		this.eoorUpsysFormerNo = eoorUpsysFormerNo;
	}
	public String getEoorDriverCode() {
		return eoorDriverCode;
	}
	public void setEoorDriverCode(String eoorDriverCode) {
		this.eoorDriverCode = eoorDriverCode;
	}
	public String getEoorDriverName() {
		return eoorDriverName;
	}
	public void setEoorDriverName(String eoorDriverName) {
		this.eoorDriverName = eoorDriverName;
	}
	public String getEoorVerhicleCode() {
		return eoorVerhicleCode;
	}
	public void setEoorVerhicleCode(String eoorVerhicleCode) {
		this.eoorVerhicleCode = eoorVerhicleCode;
	}
	public String getEoorVerhicleName() {
		return eoorVerhicleName;
	}
	public void setEoorVerhicleName(String eoorVerhicleName) {
		this.eoorVerhicleName = eoorVerhicleName;
	}
	public String getEoorrookieFalg() {
		return eoorrookieFalg;
	}
	public void setEoorrookieFalg(String eoorrookieFalg) {
		this.eoorrookieFalg = eoorrookieFalg;
	}
	public String getEoorTemporaryReason() {
		return eoorTemporaryReason;
	}
	public void setEoorTemporaryReason(String eoorTemporaryReason) {
		this.eoorTemporaryReason = eoorTemporaryReason;
	}
	public String getEoorRefundApplicationNo() {
		return eoorRefundApplicationNo;
	}
	public void setEoorRefundApplicationNo(String eoorRefundApplicationNo) {
		this.eoorRefundApplicationNo = eoorRefundApplicationNo;
	}
	public String getEoorSortingCode() {
		return eoorSortingCode;
	}
	public void setEoorSortingCode(String eoorSortingCode) {
		this.eoorSortingCode = eoorSortingCode;
	}
	public String getEoorIsSupplement() {
		return eoorIsSupplement;
	}
	public void setEoorIsSupplement(String eoorIsSupplement) {
		this.eoorIsSupplement = eoorIsSupplement;
	}
	public String getEoorIsExport() {
		return eoorIsExport;
	}
	public void setEoorIsExport(String eoorIsExport) {
		this.eoorIsExport = eoorIsExport;
	}
	public String getEoorWmsOrderNo() {
		return eoorWmsOrderNo;
	}
	public void setEoorWmsOrderNo(String eoorWmsOrderNo) {
		this.eoorWmsOrderNo = eoorWmsOrderNo;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public List<EoCOrderItem> getInOrderReceiveItemNewBean() {
		return inOrderReceiveItemNewBean;
	}
	public void setInOrderReceiveItemNewBean(
			List<EoCOrderItem> inOrderReceiveItemNewBean) {
		this.inOrderReceiveItemNewBean = inOrderReceiveItemNewBean;
	}
	/**
	 * 美标美得你下属公司编码
	 */
	public String getEoorSubordinateCompanyCode() {
		return eoorSubordinateCompanyCode;
	}

	/**
	 * 美标美得你下属公司编码
	 */
	public void setEoorSubordinateCompanyCode(String eoorSubordinateCompanyCode) {
		this.eoorSubordinateCompanyCode = eoorSubordinateCompanyCode;
	}
	public EoCOrderExtension getEoCOrderExtensionBean() {
		return eoCOrderExtensionBean;
	}
	public void setEoCOrderExtensionBean(EoCOrderExtension eoCOrderExtensionBean) {
		this.eoCOrderExtensionBean = eoCOrderExtensionBean;
	}
	public String getEoorDebonReceiveDeptCode() {
		return eoorDebonReceiveDeptCode;
	}
	public void setEoorDebonReceiveDeptCode(String eoorDebonReceiveDeptCode) {
		this.eoorDebonReceiveDeptCode = eoorDebonReceiveDeptCode;
	}


	
}
