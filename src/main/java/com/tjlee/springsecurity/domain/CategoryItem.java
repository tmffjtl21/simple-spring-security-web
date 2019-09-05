package com.tjlee.springsecurity.domain;

import javax.persistence.*;
import java.util.Objects;

//@Entity
@Table(name = "category_item", schema = "hibernate_test")
@IdClass(CategoryItemPK.class)
public class CategoryItem {
    private int categoryId;
    private int itemId;
    private Category categoryByCategoryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Id
    @Column(name = "ITEM_ID", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryItem that = (CategoryItem) o;
        return categoryId == that.categoryId &&
                itemId == that.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, itemId);
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false, insertable = false, updatable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
