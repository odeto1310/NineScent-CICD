package shop.ninescent.mall.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ninescent.mall.category.domain.Category;
import shop.ninescent.mall.category.domain.Item;
import shop.ninescent.mall.category.domain.SubCategory;
import shop.ninescent.mall.category.dto.CategoryResponseDTO;
import shop.ninescent.mall.category.dto.ItemListResponseDTO;
import shop.ninescent.mall.category.dto.SubCategoryResponseDTO;
import shop.ninescent.mall.category.repository.GetCategoryRepository;
import shop.ninescent.mall.category.repository.GetItemListRepository;
import shop.ninescent.mall.category.repository.GetSubCategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCategoryService {

    private final GetCategoryRepository getCategoryRepository;
    private final GetSubCategoryRepository getSubCategoryRepository;
    private final GetItemListRepository getItemListRepository;

    public List<CategoryResponseDTO> getAllCategories() {
        return getCategoryRepository.findAll().stream()
                .map(this::toCategoryResponseDTO)
                .collect(Collectors.toList());
    }

    public List<SubCategoryResponseDTO> getSubCategories(Long categoryId) {
        return getSubCategoryRepository.findByCategoryId(categoryId).stream()
                .map(this::toSubCategoryResponseDTO)
                .collect(Collectors.toList());
    }

    public List<ItemListResponseDTO> getItemLists(Long subCategoryId) {
        return getItemListRepository.findBySubCategoryId(subCategoryId).stream()
                .map(this::toItemListResponseDTO)
                .collect(Collectors.toList());
    }


    private CategoryResponseDTO toCategoryResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }

    private SubCategoryResponseDTO toSubCategoryResponseDTO(SubCategory subCategory) {
        SubCategoryResponseDTO dto = new SubCategoryResponseDTO();
        dto.setSubCategoryId(subCategory.getSubCategoryId());
        dto.setSubCategoryName(subCategory.getSubCategoryName());
        return dto;
    }

    private ItemListResponseDTO toItemListResponseDTO(Item item) {
        ItemListResponseDTO dto = new ItemListResponseDTO();
        dto.setItemId(item.getItemId());
        dto.setItemName(item.getItemName());
        return dto;
    }
}
