

package model;

public class ItemInBasket {
    
    private Product product;
    private int quantity;

    public ItemInBasket(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ItemInBasket() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    

}
