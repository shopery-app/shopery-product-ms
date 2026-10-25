package az.shopery.product_ms.service;

import az.shopery.product_ms.model.dto.request.ProductCreateRequestDto;
import az.shopery.product_ms.model.dto.response.ProductDetailResponseDto;
import az.shopery.product_ms.model.dto.response.ProductResponseDto;
import az.shopery.product_ms.model.dto.shared.SuccessResponse;
import az.shopery.product_ms.utils.enums.ProductCategory;
import az.shopery.product_ms.utils.enums.ProductCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    SuccessResponse<ProductDetailResponseDto> addProduct(String userEmail, ProductCreateRequestDto requestDto);
    SuccessResponse<ProductDetailResponseDto> updateProduct(String userEmail, String productId, ProductCreateRequestDto requestDto);
    SuccessResponse<byte[]> updateProductImage(String userEmail, String productId, MultipartFile imageFile);
    SuccessResponse<Void> deleteProduct(String userEmail, String productId);
    SuccessResponse<Page<ProductResponseDto>> getMyProducts(String userEmail, Pageable pageable);
    SuccessResponse<Page<ProductResponseDto>> searchPublicProducts(ProductCategory category, ProductCondition condition, Double minPrice, Double maxPrice, String keyword, Pageable pageable);
    SuccessResponse<ProductDetailResponseDto> getPublicProductById(String productId);
    SuccessResponse<Void> deleteProductImage(String userEmail, String productId);
    SuccessResponse<Page<ProductResponseDto>> getTopDiscountedProducts(Pageable pageable);
}
