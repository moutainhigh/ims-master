package com.yianju.ims.process.unit.customer.zazj.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class EoCOrderItem implements Serializable{

	private static final long serialVersionUID = 1L;
/**
     * 表物理ID主键
     */
    private Long eooiId;
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
    private Long recStatus;
    /**
     * 平台分公司
     */
    private String orgId;
    /**
     * 代码
     */
    private String pmCode;
    /**
     * 系统订单号
     */
    private String eooiOrderNo;
    /**
     * 商品代码
     */
    private String eooiCode;
    /**
     * 商品名称
     */
    private String eooiName;
    /**
     * 包装规格代码
     */
    private String eooiPackageTypeCode;
    /**
     * 包装规格名称
     */
    private String eooiPackageTypeName;
    /**
     * 包装单位代码
     */
    private String eooiPackageUnitCode;
    /**
     * 包装单位名称
     */
    private String eooiPackageUnitName;
    /**
     * 包装数量
     */
    private Double eooiPackageQuantity;
    /**
     * 件数
     */
    private Double eooiQuantity;
    /**
     * 毛重
     */
    private Double eooiGrossWeight;
    /**
     * 净重
     */
    private Double eooiNetWeight;
    /**
     * 体积
     */
    private Double eooiVolume;
    /**
     * 批次号
     */
    private String eooiLotNo;
    /**
     * 商品单价
     */
    private Double eooiPrice;
    /**
     * 商品总金额
     */
    private Double eooiAmount;
    /**
     * 温层代码
     */
    private String eooiTemperatureLevelCode;
    /**
     * 温层名称
     */
    private String eooiTemperatureLevelName;
    /**
     * 最小温度
     */
    private Double eooiTemperatureFm;
    /**
     * 最大温度
     */
    private Double eooiTemperatureTo;
    /**
     * 备注
     */
    private String eooiRemark;
    /**
     * 商品类型代码
     */
    private String eooiItemTypeCode;
    /**
     * 商品类型名称
     */
    private String eooiItemTypeName;
    /**
     * 关联行号
     */
    private String eooiLinkPmCode;
    /**
     * 生产日期
     */
    private Date eooiProductionDate;
    /**
     * 色号
     */
    private String eooiColorNo;
    /**
     * 有效期
     */
    private Double eooiShelfLife;
    /**
     * 有效期单位
     */
    private String eooiShelfLifeUnit;
    /**
     * 制造商代码
     */
    private String eooiProvideCustCode;
    /**
     * 制造商名称
     */
    private String eooiProvideCustName;
    /**
     * 商品条码
     */
    private String eooiBarCode;
    /**
     * 是否含税
     */
    private String eooiIsTax;
    /**
     * 序号
     */
    private Long eooiMaxRow;
    /**
     * 批次属性1-生产日期
     */
    private String eooiLotatt01;
    /**
     * 批次属性2-失效日期
     */
    private String eooiLotatt02;
    /**
     * 批次属性3-入库日期
     */
    private String eooiLotatt03;
    /**
     * 批次属性4-货值
     */
    private String eooiLotatt04;
    /**
     * 批次属性5-品牌
     */
    private String eooiLotatt05;
    /**
     * 批次属性6-规格
     */
    private String eooiLotatt06;
    /**
     * 批次属性7
     */
    private String eooiLotatt07;
    /**
     * 批次属性8
     */
    private String eooiLotatt08;
    /**
     * 批次属性9
     */
    private String eooiLotatt09;
    /**
     * 批次属性10
     */
    private String eooiLotatt10;
    /**
     * 批次属性11
     */
    private String eooiLotatt11;
    /**
     * 批次属性12
     */
    private String eooiLotatt12;
    /**
     * 分配数
     */
    private Double eooiAllocatedQty;
    /**
     * 签收数
     */
    private Double eooiSignQty;
    /**
     * 货值
     */
    private Double eooiCargoValue;
    /**
     * 商品等级（一等、二等、三等）
     */
    private String eooiItemRank;
    /**
     * 商品属性代码（好机、坏机）
     */
    private String eooiPropertyCode;
    /**
     * 原数量
     */
    private Double eooiOriginalQty;
    /**
     * 重量体积
     */
    private Double eooiWeightVolume;
    /**
     * 上游任务号
     */
    private String eooiLogisticNo;
    /**
     * 拦截点
     */
    private String eooiInterceptPoint;
    /**
     * 代收金额
     */
    private Double eooiCollectionAmount;
    /**
     * 商品成本
     */
    private Double eooiCost;
    /**
     * 组合标示
     */
    private String eooiCombineFlag;
    /**
     * 预售标示
     */
    private String eooiPresaleFlag;
    /**
     * 物权所有者CODE
     */
    private String eooiCustomerCode;
    /**
     * 物权所有者NAME
     */
    private String eooiCustomerName;
    /**
     * 件型
     */
    private String eooiSizeType;
    /**
     * 商品状态
     */
    private String eooiQuantityStatus;
    /**
     * 品牌
     */
    private String eooiBrand;
    /**
     * 规格
     */
    private String eooiStandard;
    /**
     * 是否赠品
     */
    private String eooiIsGift;
    /**
     * 承运商CODE
     */
    private String eooiCarrierCode;
    /**
     * 承运商NAME
     */
    private String eooiCarrierName;
    /**
     * 快递单号
     */
    private String eooiExpressNo;
    /**
     * 实际发货时间
     */
    private Date eooiDeliveryTime;
    /**
     * 实际收货时间
     */
    private Date eooiReceiverTime;
    /**
     * （新增）优惠价
     */
    private Double eooiPreferentialPrice;
    /**
     * （新增）应收价
     */
    private Double eooiReceivablePrice;
    /**
     * 退货-原单客户订单号
     */
    private String eooiOldEoorLogisticNo;
    /**
     * 客户商品编码
     */
    private String eooiCustMaterialNo;
    /**
     * 长度
     */
    private Double eooiLength;
    /**
     * 宽度
     */
    private Double eooiWideth;
    /**
     * 上游商品行号
     */
    private String eooiUpNo;
    /**
     * 订单商品ID
     */
    private String eooiOrderItemId;
    /**
     * 交易编码
     */
    private String eooiOrderSourceCode;
    /**
     * 子交易编码
     */
    private String eooiSubSourceCode;
    /**
     * 卖家ID 一般情况下，货主ID和卖家ID相同
     */
    private String eooiUserId;
    /**
     * 货主ID 代销情况下货主ID和卖家ID不同
     */
    private String eooiOwnerUserId;
    /**
     * 商品版本
     */
    private String eooiItemVersion;
    /**
     * 该商品在IC的链接
     */
    private String eooiItemUrl;
    /**
     * 商家所选择的服务种类(11: 配送到站,12: 配送到家,13: 配送到家并安装)
     */
    private String eooiServiceType;
    /**
     * 属性数据 KEY VALUE格式
     */
    private String eooiAttributes;
    /**
     * 故障类型代码
     */
    private String eooiFaultType;
    /**
     * 故障类型名称
     */
    private String eooiFaultName;
    /**
     * 是否计费标识
     */
    private String eooiIsCharge;
    /**
     * 应收是否计费(Y是，N否)
     */
    private String eooiReceiveIsCharge;
    /**
     * 应付是否计费(Y是，N否)
     */
    private String eooiPayIsCharge;
    /**
     * 发票编号
     */
    private String eooiInvoiceNo;
    /**
     * 唯一标识码
     */
    private String eooiUniqueCode;
    /**
     * 运输签收数量
     */
    private Double eooiTransportQty;
    /**
     * SKUID
     */
    private String eooiSkuId;
    /**
     * 商品编码
     */
    private String eooiItemCode;
    /**
     * 包装号
     */
    private String eooiPackageCode;
    /**
     * 货主名称
     */
    private String eooiOwnerUserName;
    /**
     * 高度
     */
    private Double eooiHeight;
    /**
     * 包材信息
     */
    private String eooiPackageMaterial;
    /**
     * 包裹SN码
     */
    private String eooiPackageSnCode;
    /**
     * 包裹条形码
     */
    private String eooiPackageBarCode;
    /**
     * 包裹重量
     */
    private Double eooiPackageWeight;
    /**
     * 包裹体积,立方厘米
     */
    private Double eooiPackageVolume;
    /**
     * 包裹长mm
     */
    private Double eooiPackageLength;
    /**
     * 包裹宽mm
     */
    private Double eooiPackageWidth;
    /**
     * 包裹高mm
     */
    private Double eooiPackageHeight;
    /**
     * 包裹扩展信息
     */
    private String eooiPackageExtendfileds;
    /**
     * 包裹备注信息
     */
    private String eooiPackageRemark;
    /**
     * sn码
     */
    private String eooiSnCode;
    /**
     * 父项号
     */
    private String eooiPerantNo;
    
    /**
     * 客户地址号
     */
    private String eooiCustomerAddressNo;
    
    /**
     * 财务仓编码
     */
    private String eooiWarehouserCode;
    /**
     * 财务仓名称
     */
    private String eooiWarehouserName;
    
    
    private String eooiCombinationSetmealCode;//套餐编码
    private String eooiCombinationSetmealName;//套餐名称
    private String eooiCombinationBomCode;//是否是套餐件
    private String eooiCombinationPack;//打包
    
    private String eooiExternalCustomerName;
    private String eooiExternalCustomerCode;
    
    //京东 JOS
    private String eooiJosServiceNo;
    private String eooiJosIsInstall;
    private Double eooiJosInstallFee;
    
    // 商品品类编码 2018-4-26
    private String eooiGoodsClzCode;
 
    // 商品品类名称 2018-4-26
    private String eooiGoodsClzName;
    
    //上游推送的原始商品明细行号
    private String eooiOriginalLineNo;
    
    //标示是否是费用类商品  中台：F或F1是费用类商品，其他不是；JDE目前已经接入费用类商品
    private String eooiLineType;
    
    private String eooiItemTypeHN;//华耐干线传递所用的商品分类
    /**
     * 加工方式
     */
    private String eooiProcessWay;
    /**
     * 加工描述
     */
    private String eooiProcessRemark;
    /**
     * 加工后规格
     */
    private String eooiFinalLength;
    /**
     * 加工后数量
     */
    private String eooiFinalQuantity;
    
    private String eooiUseSpace;//使用空间
    
    private String eooiJdeBatch;//上游JDE库位
    
    private String eooiClassLibrary;//库位类别
    
    private String eooiUpBatch;//上游批次
    
    public String getEooiUpBatch() {
		return eooiUpBatch;
	}

	public void setEooiUpBatch(String eooiUpBatch) {
		this.eooiUpBatch = eooiUpBatch;
	}

	public String getEooiClassLibrary() {
		return eooiClassLibrary;
	}

	public void setEooiClassLibrary(String eooiClassLibrary) {
		this.eooiClassLibrary = eooiClassLibrary;
	}

	public String getEooiJdeBatch() {
		return eooiJdeBatch;
	}

	public void setEooiJdeBatch(String eooiJdeBatch) {
		this.eooiJdeBatch = eooiJdeBatch;
	}

	public String getEooiUseSpace() {
		return eooiUseSpace;
	}

	public void setEooiUseSpace(String eooiUseSpace) {
		this.eooiUseSpace = eooiUseSpace;
	}

	public String getEooiItemTypeHN() {
		return eooiItemTypeHN;
	}

	public void setEooiItemTypeHN(String eooiItemTypeHN) {
		this.eooiItemTypeHN = eooiItemTypeHN;
	}

	public String getEooiOriginalLineNo() {
		return eooiOriginalLineNo;
	}

	public void setEooiOriginalLineNo(String eooiOriginalLineNo) {
		this.eooiOriginalLineNo = eooiOriginalLineNo;
	}

	public String getEooiLineType() {
		return eooiLineType;
	}

	public void setEooiLineType(String eooiLineType) {
		this.eooiLineType = eooiLineType;
	}

	List<EoCOrderItemSerial> inOrderReceiveSerialBean;
    
	public Long getEooiId() {
		return eooiId;
	}

	public void setEooiId(Long eooiId) {
		this.eooiId = eooiId;
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

	public Long getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(Long recStatus) {
		this.recStatus = recStatus;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPmCode() {
		return pmCode;
	}

	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}

	public String getEooiOrderNo() {
		return eooiOrderNo;
	}

	public void setEooiOrderNo(String eooiOrderNo) {
		this.eooiOrderNo = eooiOrderNo;
	}

	public String getEooiCode() {
		return eooiCode;
	}

	public void setEooiCode(String eooiCode) {
		this.eooiCode = eooiCode;
	}

	public String getEooiName() {
		return eooiName;
	}

	public void setEooiName(String eooiName) {
		this.eooiName = eooiName;
	}

	public String getEooiPackageTypeCode() {
		return eooiPackageTypeCode;
	}

	public void setEooiPackageTypeCode(String eooiPackageTypeCode) {
		this.eooiPackageTypeCode = eooiPackageTypeCode;
	}

	public String getEooiPackageTypeName() {
		return eooiPackageTypeName;
	}

	public void setEooiPackageTypeName(String eooiPackageTypeName) {
		this.eooiPackageTypeName = eooiPackageTypeName;
	}

	public String getEooiPackageUnitCode() {
		return eooiPackageUnitCode;
	}

	public void setEooiPackageUnitCode(String eooiPackageUnitCode) {
		this.eooiPackageUnitCode = eooiPackageUnitCode;
	}

	public String getEooiPackageUnitName() {
		return eooiPackageUnitName;
	}

	public void setEooiPackageUnitName(String eooiPackageUnitName) {
		this.eooiPackageUnitName = eooiPackageUnitName;
	}

	public Double getEooiPackageQuantity() {
		return eooiPackageQuantity;
	}

	public void setEooiPackageQuantity(Double eooiPackageQuantity) {
		this.eooiPackageQuantity = eooiPackageQuantity;
	}

	public Double getEooiQuantity() {
		return eooiQuantity;
	}

	public void setEooiQuantity(Double eooiQuantity) {
		this.eooiQuantity = eooiQuantity;
	}

	public Double getEooiGrossWeight() {
		return eooiGrossWeight;
	}

	public void setEooiGrossWeight(Double eooiGrossWeight) {
		this.eooiGrossWeight = eooiGrossWeight;
	}

	public Double getEooiNetWeight() {
		return eooiNetWeight;
	}

	public void setEooiNetWeight(Double eooiNetWeight) {
		this.eooiNetWeight = eooiNetWeight;
	}

	public Double getEooiVolume() {
		return eooiVolume;
	}

	public void setEooiVolume(Double eooiVolume) {
		this.eooiVolume = eooiVolume;
	}

	public String getEooiLotNo() {
		return eooiLotNo;
	}

	public void setEooiLotNo(String eooiLotNo) {
		this.eooiLotNo = eooiLotNo;
	}

	public Double getEooiPrice() {
		return eooiPrice;
	}

	public void setEooiPrice(Double eooiPrice) {
		this.eooiPrice = eooiPrice;
	}

	public Double getEooiAmount() {
		return eooiAmount;
	}

	public void setEooiAmount(Double eooiAmount) {
		this.eooiAmount = eooiAmount;
	}

	public String getEooiTemperatureLevelCode() {
		return eooiTemperatureLevelCode;
	}

	public void setEooiTemperatureLevelCode(String eooiTemperatureLevelCode) {
		this.eooiTemperatureLevelCode = eooiTemperatureLevelCode;
	}

	public String getEooiTemperatureLevelName() {
		return eooiTemperatureLevelName;
	}

	public void setEooiTemperatureLevelName(String eooiTemperatureLevelName) {
		this.eooiTemperatureLevelName = eooiTemperatureLevelName;
	}

	public Double getEooiTemperatureFm() {
		return eooiTemperatureFm;
	}

	public void setEooiTemperatureFm(Double eooiTemperatureFm) {
		this.eooiTemperatureFm = eooiTemperatureFm;
	}

	public Double getEooiTemperatureTo() {
		return eooiTemperatureTo;
	}

	public void setEooiTemperatureTo(Double eooiTemperatureTo) {
		this.eooiTemperatureTo = eooiTemperatureTo;
	}

	public String getEooiRemark() {
		return eooiRemark;
	}

	public void setEooiRemark(String eooiRemark) {
		this.eooiRemark = eooiRemark;
	}

	public String getEooiItemTypeCode() {
		return eooiItemTypeCode;
	}

	public void setEooiItemTypeCode(String eooiItemTypeCode) {
		this.eooiItemTypeCode = eooiItemTypeCode;
	}

	public String getEooiItemTypeName() {
		return eooiItemTypeName;
	}

	public void setEooiItemTypeName(String eooiItemTypeName) {
		this.eooiItemTypeName = eooiItemTypeName;
	}

	public String getEooiLinkPmCode() {
		return eooiLinkPmCode;
	}

	public void setEooiLinkPmCode(String eooiLinkPmCode) {
		this.eooiLinkPmCode = eooiLinkPmCode;
	}

	public Date getEooiProductionDate() {
		return eooiProductionDate;
	}

	public void setEooiProductionDate(Date eooiProductionDate) {
		this.eooiProductionDate = eooiProductionDate;
	}

	public String getEooiColorNo() {
		return eooiColorNo;
	}

	public void setEooiColorNo(String eooiColorNo) {
		this.eooiColorNo = eooiColorNo;
	}

	public Double getEooiShelfLife() {
		return eooiShelfLife;
	}

	public void setEooiShelfLife(Double eooiShelfLife) {
		this.eooiShelfLife = eooiShelfLife;
	}

	public String getEooiShelfLifeUnit() {
		return eooiShelfLifeUnit;
	}

	public void setEooiShelfLifeUnit(String eooiShelfLifeUnit) {
		this.eooiShelfLifeUnit = eooiShelfLifeUnit;
	}

	public String getEooiProvideCustCode() {
		return eooiProvideCustCode;
	}

	public void setEooiProvideCustCode(String eooiProvideCustCode) {
		this.eooiProvideCustCode = eooiProvideCustCode;
	}

	public String getEooiProvideCustName() {
		return eooiProvideCustName;
	}

	public void setEooiProvideCustName(String eooiProvideCustName) {
		this.eooiProvideCustName = eooiProvideCustName;
	}

	public String getEooiBarCode() {
		return eooiBarCode;
	}

	public void setEooiBarCode(String eooiBarCode) {
		this.eooiBarCode = eooiBarCode;
	}

	public String getEooiIsTax() {
		return eooiIsTax;
	}

	public void setEooiIsTax(String eooiIsTax) {
		this.eooiIsTax = eooiIsTax;
	}

	public Long getEooiMaxRow() {
		return eooiMaxRow;
	}

	public void setEooiMaxRow(Long eooiMaxRow) {
		this.eooiMaxRow = eooiMaxRow;
	}

	public String getEooiLotatt01() {
		return eooiLotatt01;
	}

	public void setEooiLotatt01(String eooiLotatt01) {
		this.eooiLotatt01 = eooiLotatt01;
	}

	public String getEooiLotatt02() {
		return eooiLotatt02;
	}

	public void setEooiLotatt02(String eooiLotatt02) {
		this.eooiLotatt02 = eooiLotatt02;
	}

	public String getEooiLotatt03() {
		return eooiLotatt03;
	}

	public void setEooiLotatt03(String eooiLotatt03) {
		this.eooiLotatt03 = eooiLotatt03;
	}

	public String getEooiLotatt04() {
		return eooiLotatt04;
	}

	public void setEooiLotatt04(String eooiLotatt04) {
		this.eooiLotatt04 = eooiLotatt04;
	}

	public String getEooiLotatt05() {
		return eooiLotatt05;
	}

	public void setEooiLotatt05(String eooiLotatt05) {
		this.eooiLotatt05 = eooiLotatt05;
	}

	public String getEooiLotatt06() {
		return eooiLotatt06;
	}

	public void setEooiLotatt06(String eooiLotatt06) {
		this.eooiLotatt06 = eooiLotatt06;
	}

	public String getEooiLotatt07() {
		return eooiLotatt07;
	}

	public void setEooiLotatt07(String eooiLotatt07) {
		this.eooiLotatt07 = eooiLotatt07;
	}

	public String getEooiLotatt08() {
		return eooiLotatt08;
	}

	public void setEooiLotatt08(String eooiLotatt08) {
		this.eooiLotatt08 = eooiLotatt08;
	}

	public String getEooiLotatt09() {
		return eooiLotatt09;
	}

	public void setEooiLotatt09(String eooiLotatt09) {
		this.eooiLotatt09 = eooiLotatt09;
	}

	public String getEooiLotatt10() {
		return eooiLotatt10;
	}

	public void setEooiLotatt10(String eooiLotatt10) {
		this.eooiLotatt10 = eooiLotatt10;
	}

	public String getEooiLotatt11() {
		return eooiLotatt11;
	}

	public void setEooiLotatt11(String eooiLotatt11) {
		this.eooiLotatt11 = eooiLotatt11;
	}

	public String getEooiLotatt12() {
		return eooiLotatt12;
	}

	public void setEooiLotatt12(String eooiLotatt12) {
		this.eooiLotatt12 = eooiLotatt12;
	}

	public Double getEooiAllocatedQty() {
		return eooiAllocatedQty;
	}

	public void setEooiAllocatedQty(Double eooiAllocatedQty) {
		this.eooiAllocatedQty = eooiAllocatedQty;
	}

	public Double getEooiSignQty() {
		return eooiSignQty;
	}

	public void setEooiSignQty(Double eooiSignQty) {
		this.eooiSignQty = eooiSignQty;
	}

	public Double getEooiCargoValue() {
		return eooiCargoValue;
	}

	public void setEooiCargoValue(Double eooiCargoValue) {
		this.eooiCargoValue = eooiCargoValue;
	}

	public String getEooiItemRank() {
		return eooiItemRank;
	}

	public void setEooiItemRank(String eooiItemRank) {
		this.eooiItemRank = eooiItemRank;
	}

	public String getEooiPropertyCode() {
		return eooiPropertyCode;
	}

	public void setEooiPropertyCode(String eooiPropertyCode) {
		this.eooiPropertyCode = eooiPropertyCode;
	}

	public Double getEooiOriginalQty() {
		return eooiOriginalQty;
	}

	public void setEooiOriginalQty(Double eooiOriginalQty) {
		this.eooiOriginalQty = eooiOriginalQty;
	}

	public Double getEooiWeightVolume() {
		return eooiWeightVolume;
	}

	public void setEooiWeightVolume(Double eooiWeightVolume) {
		this.eooiWeightVolume = eooiWeightVolume;
	}

	public String getEooiLogisticNo() {
		return eooiLogisticNo;
	}

	public void setEooiLogisticNo(String eooiLogisticNo) {
		this.eooiLogisticNo = eooiLogisticNo;
	}

	public String getEooiInterceptPoint() {
		return eooiInterceptPoint;
	}

	public void setEooiInterceptPoint(String eooiInterceptPoint) {
		this.eooiInterceptPoint = eooiInterceptPoint;
	}

	public Double getEooiCollectionAmount() {
		return eooiCollectionAmount;
	}

	public void setEooiCollectionAmount(Double eooiCollectionAmount) {
		this.eooiCollectionAmount = eooiCollectionAmount;
	}

	public Double getEooiCost() {
		return eooiCost;
	}

	public void setEooiCost(Double eooiCost) {
		this.eooiCost = eooiCost;
	}

	public String getEooiCombineFlag() {
		return eooiCombineFlag;
	}

	public void setEooiCombineFlag(String eooiCombineFlag) {
		this.eooiCombineFlag = eooiCombineFlag;
	}

	public String getEooiPresaleFlag() {
		return eooiPresaleFlag;
	}

	public void setEooiPresaleFlag(String eooiPresaleFlag) {
		this.eooiPresaleFlag = eooiPresaleFlag;
	}

	public String getEooiCustomerCode() {
		return eooiCustomerCode;
	}

	public void setEooiCustomerCode(String eooiCustomerCode) {
		this.eooiCustomerCode = eooiCustomerCode;
	}

	public String getEooiCustomerName() {
		return eooiCustomerName;
	}

	public void setEooiCustomerName(String eooiCustomerName) {
		this.eooiCustomerName = eooiCustomerName;
	}

	public String getEooiSizeType() {
		return eooiSizeType;
	}

	public void setEooiSizeType(String eooiSizeType) {
		this.eooiSizeType = eooiSizeType;
	}

	public String getEooiQuantityStatus() {
		return eooiQuantityStatus;
	}

	public void setEooiQuantityStatus(String eooiQuantityStatus) {
		this.eooiQuantityStatus = eooiQuantityStatus;
	}

	public String getEooiBrand() {
		return eooiBrand;
	}

	public void setEooiBrand(String eooiBrand) {
		this.eooiBrand = eooiBrand;
	}

	public String getEooiStandard() {
		return eooiStandard;
	}

	public void setEooiStandard(String eooiStandard) {
		this.eooiStandard = eooiStandard;
	}

	public String getEooiIsGift() {
		return eooiIsGift;
	}

	public void setEooiIsGift(String eooiIsGift) {
		this.eooiIsGift = eooiIsGift;
	}

	public String getEooiCarrierCode() {
		return eooiCarrierCode;
	}

	public void setEooiCarrierCode(String eooiCarrierCode) {
		this.eooiCarrierCode = eooiCarrierCode;
	}

	public String getEooiCarrierName() {
		return eooiCarrierName;
	}

	public void setEooiCarrierName(String eooiCarrierName) {
		this.eooiCarrierName = eooiCarrierName;
	}

	public String getEooiExpressNo() {
		return eooiExpressNo;
	}

	public void setEooiExpressNo(String eooiExpressNo) {
		this.eooiExpressNo = eooiExpressNo;
	}

	public Date getEooiDeliveryTime() {
		return eooiDeliveryTime;
	}

	public void setEooiDeliveryTime(Date eooiDeliveryTime) {
		this.eooiDeliveryTime = eooiDeliveryTime;
	}

	public Date getEooiReceiverTime() {
		return eooiReceiverTime;
	}

	public void setEooiReceiverTime(Date eooiReceiverTime) {
		this.eooiReceiverTime = eooiReceiverTime;
	}

	public Double getEooiPreferentialPrice() {
		return eooiPreferentialPrice;
	}

	public void setEooiPreferentialPrice(Double eooiPreferentialPrice) {
		this.eooiPreferentialPrice = eooiPreferentialPrice;
	}

	public Double getEooiReceivablePrice() {
		return eooiReceivablePrice;
	}

	public void setEooiReceivablePrice(Double eooiReceivablePrice) {
		this.eooiReceivablePrice = eooiReceivablePrice;
	}

	public String getEooiOldEoorLogisticNo() {
		return eooiOldEoorLogisticNo;
	}

	public void setEooiOldEoorLogisticNo(String eooiOldEoorLogisticNo) {
		this.eooiOldEoorLogisticNo = eooiOldEoorLogisticNo;
	}

	public String getEooiCustMaterialNo() {
		return eooiCustMaterialNo;
	}

	public void setEooiCustMaterialNo(String eooiCustMaterialNo) {
		this.eooiCustMaterialNo = eooiCustMaterialNo;
	}

	public Double getEooiLength() {
		return eooiLength;
	}

	public void setEooiLength(Double eooiLength) {
		this.eooiLength = eooiLength;
	}

	public Double getEooiWideth() {
		return eooiWideth;
	}

	public void setEooiWideth(Double eooiWideth) {
		this.eooiWideth = eooiWideth;
	}

	public String getEooiUpNo() {
		return eooiUpNo;
	}

	public void setEooiUpNo(String eooiUpNo) {
		this.eooiUpNo = eooiUpNo;
	}

	public String getEooiOrderItemId() {
		return eooiOrderItemId;
	}

	public void setEooiOrderItemId(String eooiOrderItemId) {
		this.eooiOrderItemId = eooiOrderItemId;
	}

	public String getEooiOrderSourceCode() {
		return eooiOrderSourceCode;
	}

	public void setEooiOrderSourceCode(String eooiOrderSourceCode) {
		this.eooiOrderSourceCode = eooiOrderSourceCode;
	}

	public String getEooiSubSourceCode() {
		return eooiSubSourceCode;
	}

	public void setEooiSubSourceCode(String eooiSubSourceCode) {
		this.eooiSubSourceCode = eooiSubSourceCode;
	}

	public String getEooiUserId() {
		return eooiUserId;
	}

	public void setEooiUserId(String eooiUserId) {
		this.eooiUserId = eooiUserId;
	}

	public String getEooiOwnerUserId() {
		return eooiOwnerUserId;
	}

	public void setEooiOwnerUserId(String eooiOwnerUserId) {
		this.eooiOwnerUserId = eooiOwnerUserId;
	}

	public String getEooiItemVersion() {
		return eooiItemVersion;
	}

	public void setEooiItemVersion(String eooiItemVersion) {
		this.eooiItemVersion = eooiItemVersion;
	}

	public String getEooiItemUrl() {
		return eooiItemUrl;
	}

	public void setEooiItemUrl(String eooiItemUrl) {
		this.eooiItemUrl = eooiItemUrl;
	}

	public String getEooiServiceType() {
		return eooiServiceType;
	}

	public void setEooiServiceType(String eooiServiceType) {
		this.eooiServiceType = eooiServiceType;
	}

	public String getEooiAttributes() {
		return eooiAttributes;
	}

	public void setEooiAttributes(String eooiAttributes) {
		this.eooiAttributes = eooiAttributes;
	}

	public String getEooiFaultType() {
		return eooiFaultType;
	}

	public void setEooiFaultType(String eooiFaultType) {
		this.eooiFaultType = eooiFaultType;
	}

	public String getEooiFaultName() {
		return eooiFaultName;
	}

	public void setEooiFaultName(String eooiFaultName) {
		this.eooiFaultName = eooiFaultName;
	}

	public String getEooiIsCharge() {
		return eooiIsCharge;
	}

	public void setEooiIsCharge(String eooiIsCharge) {
		this.eooiIsCharge = eooiIsCharge;
	}

	public String getEooiReceiveIsCharge() {
		return eooiReceiveIsCharge;
	}

	public void setEooiReceiveIsCharge(String eooiReceiveIsCharge) {
		this.eooiReceiveIsCharge = eooiReceiveIsCharge;
	}

	public String getEooiPayIsCharge() {
		return eooiPayIsCharge;
	}

	public void setEooiPayIsCharge(String eooiPayIsCharge) {
		this.eooiPayIsCharge = eooiPayIsCharge;
	}

	public String getEooiInvoiceNo() {
		return eooiInvoiceNo;
	}

	public void setEooiInvoiceNo(String eooiInvoiceNo) {
		this.eooiInvoiceNo = eooiInvoiceNo;
	}

	public String getEooiUniqueCode() {
		return eooiUniqueCode;
	}

	public void setEooiUniqueCode(String eooiUniqueCode) {
		this.eooiUniqueCode = eooiUniqueCode;
	}

	public Double getEooiTransportQty() {
		return eooiTransportQty;
	}

	public void setEooiTransportQty(Double eooiTransportQty) {
		this.eooiTransportQty = eooiTransportQty;
	}

	public String getEooiSkuId() {
		return eooiSkuId;
	}

	public void setEooiSkuId(String eooiSkuId) {
		this.eooiSkuId = eooiSkuId;
	}

	public String getEooiItemCode() {
		return eooiItemCode;
	}

	public void setEooiItemCode(String eooiItemCode) {
		this.eooiItemCode = eooiItemCode;
	}

	public String getEooiPackageCode() {
		return eooiPackageCode;
	}

	public void setEooiPackageCode(String eooiPackageCode) {
		this.eooiPackageCode = eooiPackageCode;
	}

	public String getEooiOwnerUserName() {
		return eooiOwnerUserName;
	}

	public void setEooiOwnerUserName(String eooiOwnerUserName) {
		this.eooiOwnerUserName = eooiOwnerUserName;
	}

	public Double getEooiHeight() {
		return eooiHeight;
	}

	public void setEooiHeight(Double eooiHeight) {
		this.eooiHeight = eooiHeight;
	}

	public String getEooiPackageMaterial() {
		return eooiPackageMaterial;
	}

	public void setEooiPackageMaterial(String eooiPackageMaterial) {
		this.eooiPackageMaterial = eooiPackageMaterial;
	}

	public String getEooiPackageSnCode() {
		return eooiPackageSnCode;
	}

	public void setEooiPackageSnCode(String eooiPackageSnCode) {
		this.eooiPackageSnCode = eooiPackageSnCode;
	}

	public String getEooiPackageBarCode() {
		return eooiPackageBarCode;
	}

	public void setEooiPackageBarCode(String eooiPackageBarCode) {
		this.eooiPackageBarCode = eooiPackageBarCode;
	}

	public Double getEooiPackageWeight() {
		return eooiPackageWeight;
	}

	public void setEooiPackageWeight(Double eooiPackageWeight) {
		this.eooiPackageWeight = eooiPackageWeight;
	}

	public Double getEooiPackageVolume() {
		return eooiPackageVolume;
	}

	public void setEooiPackageVolume(Double eooiPackageVolume) {
		this.eooiPackageVolume = eooiPackageVolume;
	}

	public Double getEooiPackageLength() {
		return eooiPackageLength;
	}

	public void setEooiPackageLength(Double eooiPackageLength) {
		this.eooiPackageLength = eooiPackageLength;
	}

	public Double getEooiPackageWidth() {
		return eooiPackageWidth;
	}

	public void setEooiPackageWidth(Double eooiPackageWidth) {
		this.eooiPackageWidth = eooiPackageWidth;
	}

	public Double getEooiPackageHeight() {
		return eooiPackageHeight;
	}

	public void setEooiPackageHeight(Double eooiPackageHeight) {
		this.eooiPackageHeight = eooiPackageHeight;
	}

	public String getEooiPackageExtendfileds() {
		return eooiPackageExtendfileds;
	}

	public void setEooiPackageExtendfileds(String eooiPackageExtendfileds) {
		this.eooiPackageExtendfileds = eooiPackageExtendfileds;
	}

	public String getEooiPackageRemark() {
		return eooiPackageRemark;
	}

	public void setEooiPackageRemark(String eooiPackageRemark) {
		this.eooiPackageRemark = eooiPackageRemark;
	}

	public String getEooiSnCode() {
		return eooiSnCode;
	}

	public void setEooiSnCode(String eooiSnCode) {
		this.eooiSnCode = eooiSnCode;
	}

	public String getEooiPerantNo() {
		return eooiPerantNo;
	}

	public void setEooiPerantNo(String eooiPerantNo) {
		this.eooiPerantNo = eooiPerantNo;
	}

	public String getEooiCustomerAddressNo() {
		return eooiCustomerAddressNo;
	}

	public void setEooiCustomerAddressNo(String eooiCustomerAddressNo) {
		this.eooiCustomerAddressNo = eooiCustomerAddressNo;
	}

	public List<EoCOrderItemSerial> getInOrderReceiveSerialBean() {
		return inOrderReceiveSerialBean;
	}

	public void setInOrderReceiveSerialBean(
			List<EoCOrderItemSerial> inOrderReceiveSerialBean) {
		this.inOrderReceiveSerialBean = inOrderReceiveSerialBean;
	}

	public String getEooiWarehouserCode() {
		return eooiWarehouserCode;
	}

	public void setEooiWarehouserCode(String eooiWarehouserCode) {
		this.eooiWarehouserCode = eooiWarehouserCode;
	}

	public String getEooiWarehouserName() {
		return eooiWarehouserName;
	}

	public void setEooiWarehouserName(String eooiWarehouserName) {
		this.eooiWarehouserName = eooiWarehouserName;
	}

	public String getEooiCombinationSetmealCode() {
		return eooiCombinationSetmealCode;
	}

	public void setEooiCombinationSetmealCode(String eooiCombinationSetmealCode) {
		this.eooiCombinationSetmealCode = eooiCombinationSetmealCode;
	}

	public String getEooiCombinationSetmealName() {
		return eooiCombinationSetmealName;
	}

	public void setEooiCombinationSetmealName(String eooiCombinationSetmealName) {
		this.eooiCombinationSetmealName = eooiCombinationSetmealName;
	}

	public String getEooiCombinationBomCode() {
		return eooiCombinationBomCode;
	}

	public void setEooiCombinationBomCode(String eooiCombinationBomCode) {
		this.eooiCombinationBomCode = eooiCombinationBomCode;
	}

	public String getEooiCombinationPack() {
		return eooiCombinationPack;
	}

	public void setEooiCombinationPack(String eooiCombinationPack) {
		this.eooiCombinationPack = eooiCombinationPack;
	}

	public String getEooiExternalCustomerName() {
		return eooiExternalCustomerName;
	}

	public void setEooiExternalCustomerName(String eooiExternalCustomerName) {
		this.eooiExternalCustomerName = eooiExternalCustomerName;
	}

	public String getEooiExternalCustomerCode() {
		return eooiExternalCustomerCode;
	}

	public void setEooiExternalCustomerCode(String eooiExternalCustomerCode) {
		this.eooiExternalCustomerCode = eooiExternalCustomerCode;
	}

	public String getEooiJosServiceNo() {
		return eooiJosServiceNo;
	}

	public void setEooiJosServiceNo(String eooiJosServiceNo) {
		this.eooiJosServiceNo = eooiJosServiceNo;
	}

	public String getEooiJosIsInstall() {
		return eooiJosIsInstall;
	}

	public void setEooiJosIsInstall(String eooiJosIsInstall) {
		this.eooiJosIsInstall = eooiJosIsInstall;
	}

	public Double getEooiJosInstallFee() {
		return eooiJosInstallFee;
	}

	public void setEooiJosInstallFee(Double eooiJosInstallFee) {
		this.eooiJosInstallFee = eooiJosInstallFee;
	}

	public String getEooiGoodsClzCode() {
		return eooiGoodsClzCode;
	}

	public void setEooiGoodsClzCode(String eooiGoodsClzCode) {
		this.eooiGoodsClzCode = eooiGoodsClzCode;
	}

	public String getEooiGoodsClzName() {
		return eooiGoodsClzName;
	}

	public void setEooiGoodsClzName(String eooiGoodsClzName) {
		this.eooiGoodsClzName = eooiGoodsClzName;
	}

    public String getEooiProcessWay() {
        return eooiProcessWay;
    }

    public void setEooiProcessWay(String eooiProcessWay) {
        this.eooiProcessWay = eooiProcessWay;
    }

    public String getEooiProcessRemark() {
        return eooiProcessRemark;
    }

    public void setEooiProcessRemark(String eooiProcessRemark) {
        this.eooiProcessRemark = eooiProcessRemark;
    }

    public String getEooiFinalLength() {
        return eooiFinalLength;
    }

    public void setEooiFinalLength(String eooiFinalLength) {
        this.eooiFinalLength = eooiFinalLength;
    }

    public String getEooiFinalQuantity() {
        return eooiFinalQuantity;
    }

    public void setEooiFinalQuantity(String eooiFinalQuantity) {
        this.eooiFinalQuantity = eooiFinalQuantity;
    }
    
}
