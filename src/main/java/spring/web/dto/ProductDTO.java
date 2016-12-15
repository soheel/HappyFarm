package spring.web.dto;

import java.util.List;

public class ProductDTO {
   
   private int no;
   private String name;
   private int price;
   private String profile;
   private String desc;
   private double eval;
   private String unit;
   private int producerNo;
   private int subCategoryNo;
   
   private PackageDTO packageDTO;
   

   private ProducerDTO producerDto;
   private List<ProductCertificationDTO> productCertificationDto;
   private CategorySubcategoryDTO subCategoryDto;
   private PurchaseProductDTO purchaseProductDto;
   private CartDTO cartDto;
   
   public ProductDTO() {
      // TODO Auto-generated constructor stub
   }

   public ProductDTO(int no, String name, int price, String profile, String desc, double eval, String unit,
         int producerNo, int subCategoryNo) {
      super();
      this.no = no;
      this.name = name;
      this.price = price;
      this.profile = profile;
      this.desc = desc;
      this.eval = eval;
      this.unit = unit;
      this.producerNo = producerNo;
      this.subCategoryNo = subCategoryNo;
   }

   public PackageDTO getPackageDTO() {
      return packageDTO;
   }

   public void setPackageDTO(PackageDTO packageDTO) {
      this.packageDTO = packageDTO;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getProfile() {
      return profile;
   }

   public void setProfile(String profile) {
      this.profile = profile;
   }

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   public double getEval() {
      return eval;
   }

   public void setEval(double eval) {
      this.eval = eval;
   }

   public String getUnit() {
      return unit;
   }

   public void setUnit(String unit) {
      this.unit = unit;
   }

   public int getProducerNo() {
      return producerNo;
   }

   public void setProducerNo(int producerNo) {
      this.producerNo = producerNo;
   }

   public int getSubCategoryNo() {
      return subCategoryNo;
   }

   public void setSubCategoryNo(int subCategoryNo) {
      this.subCategoryNo = subCategoryNo;
   }

   

   public ProducerDTO getProducerDto() {
	return producerDto;
}

   	public void setProducerDto(ProducerDTO producerDto) {
	this.producerDto = producerDto;
	}

	public List<ProductCertificationDTO> getProductCertificationDto() {
      return productCertificationDto;
   }

   public void setProductCertificationDto(List<ProductCertificationDTO> productCertificationDto) {
      this.productCertificationDto = productCertificationDto;
   }

   public CategorySubcategoryDTO getSubCategoryDto() {
      return subCategoryDto;
   }

   public void setSubCategoryDto(CategorySubcategoryDTO subCategoryDto) {
      this.subCategoryDto = subCategoryDto;
   }

   public PurchaseProductDTO getPurchaseProductDto() {
      return purchaseProductDto;
   }

   public void setPurchaseProductDto(PurchaseProductDTO purchaseProductDto) {
      this.purchaseProductDto = purchaseProductDto;
   }

   public CartDTO getCartDto() {
      return cartDto;
   }

   public void setCartDto(CartDTO cartDto) {
      this.cartDto = cartDto;
   }

   
}