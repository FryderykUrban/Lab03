package pakiecik;

public class Product {
    private String productName;

    public String getProductName() {
        return productName;
    }

    public int getNeededAmonutOfProduct() {
        return neededAmountOfProduct;
    }

    public int getProvidedAmountOfProduct() {
        return providedAmountOfProduct;
    }

    private int neededAmountOfProduct;
    private int providedAmountOfProduct;//provided amount of product

    public int getNrr() {
        return nrr;
    }

    private int nrr;

    public void setProvidedAmountOfProduct(int providedAmountOfProduct) {
        this.providedAmountOfProduct = providedAmountOfProduct;
    }

    public Product(String productName, int nAOP, int pAOP, int nrr) {
        this.productName = productName;
        this.neededAmountOfProduct = nAOP;
        this.providedAmountOfProduct = pAOP;
        this.nrr= nrr;
    }
}
