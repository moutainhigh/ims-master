package com.yianju.ims.process.unit.customer.zazj.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class EoCOrderExtension implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4886009694760019157L;
	/**
	 * 主键ID
	 */
	private Long ecoeId;
	/**
	 * 中台对接jde单号
	 */
	private String ecoeJdeNo;
	/**
	 * 关联订单表AD单号
	 */
	private String ecoeEoorOrderNo;
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
	 * ecoe_is_multi
	 * 是否一人多单
	 */
	private Long ecoeIsMulti;
	
	/**
	 * ECOE_SALEMAN_PHONE
	 * 售货员电话
	 */
	private String ecoeSalemanPhone;
	
	/**
	 * ECOE_GUIDE_PHONE
	 * 导购电话
	 */
	private String ecoeGuidePhone;
	
	/**
	 * 上游客户编码
	 */
	private String ecoeUpCompanyCode;
	
	/**
	 * 是否与加工砖同送 0否，1是
	 */
	private String ecoeIsDeliveryBrick;
	
	/**
	 * 加工单状态 0未加工，1提货中，2已出库，3已加工
	 */
	private String ecoeProcessingStatus;
	
	/**
	 * 原始服务类型
	 */
	private String ecoeJdeServiceNo;
	
	/**
	 * 订单来源
	 */
	private String ecoeEoorSourceCode;
	
	/**
	 * 大客户订单收货人
	 */
	private String ecoeBigReciverName;
	
	/**
	 * 大客户订单收货人邮箱
	 */
	private String ecoeBigEmail;
	
	/**
	 * 大客户订单收货人手机
	 */
	private String ecoeBigReciverPhone;
	
	/**
	 * 供货方
	 */
	private String ecoeBigbSupplier;
	
	/**
	 * 采购方
	 */
	private String ecoeBigPirchaser;
	
	/**
	 * 工程项目名称
	 */
	private String ecoeBigPorjectName;
	
	/**
	 * 联系电话
	 */
	private String ecoeBigTel;
	/**
	 * 是否是 手工建单/批量导入
	 */
	private String ecoeSingleImport;
	
	/**
	 * 商家版校验是否勾选图片
	 */
	private String ecoeCheckPicture;
	
	/**
	 * 开票主体 ECOE_TICKET_SUBJECT
	 */
	private String ecoeTicketSubject;
	/**
	 * 是否含税 ECOE_EXIST_TAX
	 */
	private String ecoeExistTax;
	/**
	 * 计费方式 ECOE_FEE_METHOD
	 */
	private String ecoeFeeMethod;
	/**
	 * 结算方式 ECOE_SETTLEMENT_METHOD
	 */
	private String ecoeSettlementMethod;
	
	private String ecoeQuotedPrice;//是否报价  0否  1是
	
	private String ecoeBrandManufacturers;//品牌厂家
	
	private String ecoeEngineeringName;//工程名称
	
	private String ecoeCommodityValue;//商品货值
	
	private String ecoeUpWareHouseName;//华耐干线传递所用的仓库名称
	
	/**
	 * 加工厂名称
	 */
	private String ecoeProcePlant;
	

    // 20190214新增oms合作关系信息
 	private String ecoeBuyerName;  //购买人
 	private String ecoeBuyerPhone; //电话
 	private String ecoeUpCompanyName; //订单公司名称
 	private String ecoeJdeCustomCode; //JDE客户号
 	private String ecoeUpCarrier; //承运商
 	private String ecoeOwnnerCode; //货主编码
 	private String ecoeOwnnerName; //货主名称
 	
 	private String ecoeTicketSubjectCode;//华耐干线--会计主体代码
 	private String ecoeIsProcessSplit;//标识加工拆分控制需要显示，0初始运输 1初始出库  2加工审核已处理
 	private String ecoeQuotationBatch;//华耐干线--报价批次号
	private String ecoeQuotationType;//华耐干线--报价类型
	private String ecoeNumberPlate;//华耐干线--上游车牌号
	private String ecoeDriverName;//华耐干线--司机
	private String ecoeDrivePhone;//华耐干线--司机联系方式
	private Double ecoeFreight;//运费
	
	private Double ecoeUnitPrice;//华耐干线--运费单价
	
	public Double getEcoeUnitPrice() {
		return ecoeUnitPrice;
	}

	public void setEcoeUnitPrice(Double ecoeUnitPrice) {
		this.ecoeUnitPrice = ecoeUnitPrice;
	}

	public String getEcoeNumberPlate() {
		return ecoeNumberPlate;
	}

	public void setEcoeNumberPlate(String ecoeNumberPlate) {
		this.ecoeNumberPlate = ecoeNumberPlate;
	}

	public String getEcoeDriverName() {
		return ecoeDriverName;
	}

	public void setEcoeDriverName(String ecoeDriverName) {
		this.ecoeDriverName = ecoeDriverName;
	}

	public String getEcoeDrivePhone() {
		return ecoeDrivePhone;
	}

	public void setEcoeDrivePhone(String ecoeDrivePhone) {
		this.ecoeDrivePhone = ecoeDrivePhone;
	}

	public Double getEcoeFreight() {
		return ecoeFreight;
	}

	public void setEcoeFreight(Double ecoeFreight) {
		this.ecoeFreight = ecoeFreight;
	}

	public String getEcoeQuotationBatch() {
		return ecoeQuotationBatch;
	}

	public void setEcoeQuotationBatch(String ecoeQuotationBatch) {
		this.ecoeQuotationBatch = ecoeQuotationBatch;
	}

	public String getEcoeQuotationType() {
		return ecoeQuotationType;
	}

	public void setEcoeQuotationType(String ecoeQuotationType) {
		this.ecoeQuotationType = ecoeQuotationType;
	}

	public String getEcoeIsProcessSplit() {
		return ecoeIsProcessSplit;
	}

	public void setEcoeIsProcessSplit(String ecoeIsProcessSplit) {
		this.ecoeIsProcessSplit = ecoeIsProcessSplit;
	}

	public String getEcoeTicketSubjectCode() {
		return ecoeTicketSubjectCode;
	}

	public void setEcoeTicketSubjectCode(String ecoeTicketSubjectCode) {
		this.ecoeTicketSubjectCode = ecoeTicketSubjectCode;
	}
    
    public String getEcoeBuyerName() {
		return ecoeBuyerName;
	}
	public void setEcoeBuyerName(String ecoeBuyerName) {
		this.ecoeBuyerName = ecoeBuyerName;
	}
	public String getEcoeBuyerPhone() {
		return ecoeBuyerPhone;
	}
	public void setEcoeBuyerPhone(String ecoeBuyerPhone) {
		this.ecoeBuyerPhone = ecoeBuyerPhone;
	}
	public String getEcoeUpCompanyName() {
		return ecoeUpCompanyName;
	}
	public void setEcoeUpCompanyName(String ecoeUpCompanyName) {
		this.ecoeUpCompanyName = ecoeUpCompanyName;
	}
	public String getEcoeJdeCustomCode() {
		return ecoeJdeCustomCode;
	}
	public void setEcoeJdeCustomCode(String ecoeJdeCustomCode) {
		this.ecoeJdeCustomCode = ecoeJdeCustomCode;
	}
	public String getEcoeUpCarrier() {
		return ecoeUpCarrier;
	}
	public void setEcoeUpCarrier(String ecoeUpCarrier) {
		this.ecoeUpCarrier = ecoeUpCarrier;
	}
	public String getEcoeOwnnerCode() {
		return ecoeOwnnerCode;
	}
	public void setEcoeOwnnerCode(String ecoeOwnnerCode) {
		this.ecoeOwnnerCode = ecoeOwnnerCode;
	}
	public String getEcoeOwnnerName() {
		return ecoeOwnnerName;
	}
	public void setEcoeOwnnerName(String ecoeOwnnerName) {
		this.ecoeOwnnerName = ecoeOwnnerName;
	}
	
	public String getEcoeUpWareHouseName() {
		return ecoeUpWareHouseName;
	}

	public void setEcoeUpWareHouseName(String ecoeUpWareHouseName) {
		this.ecoeUpWareHouseName = ecoeUpWareHouseName;
	}

	public String getEcoeSingleImport() {
		return ecoeSingleImport;
	}

	public void setEcoeSingleImport(String ecoeSingleImport) {
		this.ecoeSingleImport = ecoeSingleImport;
	}

	public String getEcoeCheckPicture() {
		return ecoeCheckPicture;
	}

	public void setEcoeCheckPicture(String ecoeCheckPicture) {
		this.ecoeCheckPicture = ecoeCheckPicture;
	}

	public String getEcoeTicketSubject() {
		return ecoeTicketSubject;
	}

	public void setEcoeTicketSubject(String ecoeTicketSubject) {
		this.ecoeTicketSubject = ecoeTicketSubject;
	}

	public String getEcoeExistTax() {
		return ecoeExistTax;
	}

	public void setEcoeExistTax(String ecoeExistTax) {
		this.ecoeExistTax = ecoeExistTax;
	}

	public String getEcoeFeeMethod() {
		return ecoeFeeMethod;
	}

	public void setEcoeFeeMethod(String ecoeFeeMethod) {
		this.ecoeFeeMethod = ecoeFeeMethod;
	}

	public String getEcoeSettlementMethod() {
		return ecoeSettlementMethod;
	}

	public void setEcoeSettlementMethod(String ecoeSettlementMethod) {
		this.ecoeSettlementMethod = ecoeSettlementMethod;
	}

	public String getEcoeQuotedPrice() {
		return ecoeQuotedPrice;
	}

	public void setEcoeQuotedPrice(String ecoeQuotedPrice) {
		this.ecoeQuotedPrice = ecoeQuotedPrice;
	}

	public String getEcoeBrandManufacturers() {
		return ecoeBrandManufacturers;
	}

	public void setEcoeBrandManufacturers(String ecoeBrandManufacturers) {
		this.ecoeBrandManufacturers = ecoeBrandManufacturers;
	}

	public String getEcoeEngineeringName() {
		return ecoeEngineeringName;
	}

	public void setEcoeEngineeringName(String ecoeEngineeringName) {
		this.ecoeEngineeringName = ecoeEngineeringName;
	}

	public String getEcoeCommodityValue() {
		return ecoeCommodityValue;
	}

	public void setEcoeCommodityValue(String ecoeCommodityValue) {
		this.ecoeCommodityValue = ecoeCommodityValue;
	}

	public String getEcoeJdeServiceNo() {
		return ecoeJdeServiceNo;
	}

	public void setEcoeJdeServiceNo(String ecoeJdeServiceNo) {
		this.ecoeJdeServiceNo = ecoeJdeServiceNo;
	}

	public String getEcoeEoorSourceCode() {
		return ecoeEoorSourceCode;
	}

	public void setEcoeEoorSourceCode(String ecoeEoorSourceCode) {
		this.ecoeEoorSourceCode = ecoeEoorSourceCode;
	}

	public String getEcoeBigReciverName() {
		return ecoeBigReciverName;
	}

	public void setEcoeBigReciverName(String ecoeBigReciverName) {
		this.ecoeBigReciverName = ecoeBigReciverName;
	}

	public String getEcoeBigEmail() {
		return ecoeBigEmail;
	}

	public void setEcoeBigEmail(String ecoeBigEmail) {
		this.ecoeBigEmail = ecoeBigEmail;
	}

	public String getEcoeBigReciverPhone() {
		return ecoeBigReciverPhone;
	}

	public void setEcoeBigReciverPhone(String ecoeBigReciverPhone) {
		this.ecoeBigReciverPhone = ecoeBigReciverPhone;
	}

	public String getEcoeBigbSupplier() {
		return ecoeBigbSupplier;
	}

	public void setEcoeBigbSupplier(String ecoeBigbSupplier) {
		this.ecoeBigbSupplier = ecoeBigbSupplier;
	}

	public String getEcoeBigPirchaser() {
		return ecoeBigPirchaser;
	}

	public void setEcoeBigPirchaser(String ecoeBigPirchaser) {
		this.ecoeBigPirchaser = ecoeBigPirchaser;
	}

	public String getEcoeBigPorjectName() {
		return ecoeBigPorjectName;
	}

	public void setEcoeBigPorjectName(String ecoeBigPorjectName) {
		this.ecoeBigPorjectName = ecoeBigPorjectName;
	}

	public String getEcoeBigTel() {
		return ecoeBigTel;
	}

	public void setEcoeBigTel(String ecoeBigTel) {
		this.ecoeBigTel = ecoeBigTel;
	}

	public String getEcoeUpCompanyCode() {
		return ecoeUpCompanyCode;
	}

	public void setEcoeUpCompanyCode(String ecoeUpCompanyCode) {
		this.ecoeUpCompanyCode = ecoeUpCompanyCode;
	}

	public String getEcoeIsDeliveryBrick() {
		return ecoeIsDeliveryBrick;
	}

	public void setEcoeIsDeliveryBrick(String ecoeIsDeliveryBrick) {
		this.ecoeIsDeliveryBrick = ecoeIsDeliveryBrick;
	}

	public String getEcoeProcessingStatus() {
		return ecoeProcessingStatus;
	}

	public void setEcoeProcessingStatus(String ecoeProcessingStatus) {
		this.ecoeProcessingStatus = ecoeProcessingStatus;
	}

	public Long getEcoeId() {
		return ecoeId;
	}

	public void setEcoeId(Long ecoeId) {
		this.ecoeId = ecoeId;
	}

	public String getEcoeJdeNo() {
		return ecoeJdeNo;
	}

	public void setEcoeJdeNo(String ecoeJdeNo) {
		this.ecoeJdeNo = ecoeJdeNo;
	}

	public String getEcoeEoorOrderNo() {
		return ecoeEoorOrderNo;
	}

	public void setEcoeEoorOrderNo(String ecoeEoorOrderNo) {
		this.ecoeEoorOrderNo = ecoeEoorOrderNo;
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

	public Long getEcoeIsMulti() {
		return ecoeIsMulti;
	}

	public void setEcoeIsMulti(Long ecoeIsMulti) {
		this.ecoeIsMulti = ecoeIsMulti;
	}

	public String getEcoeSalemanPhone() {
		return ecoeSalemanPhone;
	}

	public void setEcoeSalemanPhone(String ecoeSalemanPhone) {
		this.ecoeSalemanPhone = ecoeSalemanPhone;
	}

	public String getEcoeGuidePhone() {
		return ecoeGuidePhone;
	}

	public void setEcoeGuidePhone(String ecoeGuidePhone) {
		this.ecoeGuidePhone = ecoeGuidePhone;
	}

    public String getEcoeProcePlant() {
        return ecoeProcePlant;
    }

    public void setEcoeProcePlant(String ecoeProcePlant) {
        this.ecoeProcePlant = ecoeProcePlant;
    }

	
}
