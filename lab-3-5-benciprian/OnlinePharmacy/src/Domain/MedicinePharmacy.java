package Domain;

import java.util.Objects;

public class MedicinePharmacy {
    private  String id;
    private String name;
    private String manufacturer;
    private double price;
    private boolean requires_prescription;

    public MedicinePharmacy(String id, String name, String manufacturer, double price, boolean requires_prescription) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.requires_prescription = requires_prescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicinePharmacy that = (MedicinePharmacy) o;
        return Double.compare(that.price, price) == 0 && requires_prescription == that.requires_prescription && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, price, requires_prescription);
    }

    public  String getId() {
        return id;
    }

    public void setId_medicine(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    public boolean isRequires_prescription() {
        return requires_prescription;
    }

    public void setRequires_prescription(boolean requires_prescription) {
        this.requires_prescription = requires_prescription;
    }

    @Override
    public String toString() {
        return "MedicinePharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", requires_prescription=" + requires_prescription +
                '}';
    }
}
