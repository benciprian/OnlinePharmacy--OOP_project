package Domain;

import java.util.Objects;

public class TransactionPharmacy {
    private String id;
    private  String id_medicine;
    private String id_card_client;
    private int number_of_Items;
    private String date_and_time;
    private double discount;
    private double finallyPrice;

    public TransactionPharmacy(String id, String id_medicine, String id_card_client, int number_of_Items, String date_and_time,double discount , double finallyPrice){
        this.id = id;
        this.id_medicine = id_medicine;
        this.id_card_client = id_card_client;
        this.number_of_Items = number_of_Items;
        this.date_and_time = date_and_time;
        this.discount = discount;
        this.finallyPrice = finallyPrice;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPharmacy that = (TransactionPharmacy) o;
        return number_of_Items == that.number_of_Items && Objects.equals(id, that.id) && Objects.equals(id_medicine, that.id_medicine) && Objects.equals(id_card_client, that.id_card_client) && Objects.equals(date_and_time, that.date_and_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_medicine, id_card_client, number_of_Items, date_and_time);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(String id_medicine) {
        this.id_medicine = id_medicine;
    }

    public String getId_card_client() {
        return id_card_client;
    }

    public void setId_card_client(String id_card_client) {
        this.id_card_client = id_card_client;
    }

    public int getNumber_of_Items() {
        return number_of_Items;
    }

    public void setNumber_of_Items(int number_of_Items) {
        this.number_of_Items = number_of_Items;
    }

    public String getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(String date_and_time) {
        this.date_and_time = date_and_time;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinallyPrice() {
        return finallyPrice;
    }

    public void setFinallyPrice(double finallyPrice) {
        this.finallyPrice = finallyPrice;
    }

    /* public double getDiscount(MedicinePharmacy medicinePharmacy) {
                if (id_card_client != null) {
                    if (medicinePharmacy.isRequires_prescription()) {
                        return 0.15;
                    } else {
                        return 0.1;
                    }
                } else {
                    return 0.0;
                }
            }
            public double getPaidPrice(MedicinePharmacy medicinePharmacy) {
                double price = number_of_Items * medicinePharmacy.getPrice();
                double reducere = price * getDiscount(medicinePharmacy);
                return price - reducere;
            }*/
    /*public void calculatePrice(MedicinePharmacy medicinePharmacy) {
        double totalPrice = medicinePharmacy.getPrice() * number_of_Items;
        double discount = 0.0;
        if (id_card_client != null) {
            boolean requires_prescription = medicinePharmacy.isRequires_prescription();
            if (requires_prescription) {
                discount = totalPrice * 0.15;
            } else {
                discount = totalPrice * 0.10;
            }
        }
        double finallyPrice = totalPrice - discount;
        System.out.println("Pretul platit: " + finallyPrice);
        System.out.println("Reduceri acordate: " + discount);
    }*/


    @Override
    public String toString() {
        return "TransactionPharmacy{" +
                "id='" + id + '\'' +
                ", id_medicine='" + id_medicine + '\'' +
                ", id_card_client='" + id_card_client + '\'' +
                ", number_of_Items=" + number_of_Items +
                ", date_and_time='" + date_and_time + '\'' +
                ", discount=" + discount +
                ", finallyPrice=" + finallyPrice +
                '}';
    }
}


