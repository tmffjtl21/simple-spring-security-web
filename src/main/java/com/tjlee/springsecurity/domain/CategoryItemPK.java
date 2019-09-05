package com.tjlee.springsecurity.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CategoryItemPK implements Serializable {
    private int categoryId;
    private int itemId;


    @Id
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
        CategoryItemPK that = (CategoryItemPK) o;
        return categoryId == that.categoryId &&
                itemId == that.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, itemId);
    }
}
