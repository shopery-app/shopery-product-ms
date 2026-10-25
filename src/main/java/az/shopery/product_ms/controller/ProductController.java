package az.shopery.product_ms.controller;

import az.shopery.product_ms.model.dto.request.ProductCreateRequestDto;
import az.shopery.product_ms.model.dto.response.ProductDetailResponseDto;
import az.shopery.product_ms.model.dto.response.ProductResponseDto;
import az.shopery.product_ms.model.dto.shared.SuccessResponse;
import az.shopery.product_ms.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/me/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<SuccessResponse<ProductDetailResponseDto>> addProduct(@RequestParam String email, @RequestBody @Valid ProductCreateRequestDto productCreateRequestDto) {
        return ResponseEntity.ok(productService.addProduct(email, productCreateRequestDto));
    }

    @PostMapping(value = "/{productId}/image", consumes = {"multipart/form-data"})
    public ResponseEntity<SuccessResponse<byte[]>> uploadProductImage(@RequestParam String email, @PathVariable String productId, @RequestParam("image") MultipartFile imageFile) {
        return ResponseEntity.ok(productService.updateProductImage(email, productId, imageFile));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<Page<ProductResponseDto>>> getMyProducts(@RequestParam String email, Pageable pageable) {
        return ResponseEntity.ok(productService.getMyProducts(email, pageable));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<SuccessResponse<ProductDetailResponseDto>> updateProduct(@RequestParam String email, @PathVariable String productId, @Valid @RequestBody ProductCreateRequestDto productCreateRequestDto) {
        return ResponseEntity.ok(productService.updateProduct(email, productId, productCreateRequestDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<SuccessResponse<Void>> deleteProduct(@RequestParam String email, @PathVariable String productId) {
        return ResponseEntity.ok(productService.deleteProduct(email, productId));
    }

    @DeleteMapping("/{productId}/image")
    public ResponseEntity<SuccessResponse<Void>> deleteProductImage(@RequestParam String email, @PathVariable String productId) {
        return ResponseEntity.ok(productService.deleteProductImage(email, productId));
    }
}
