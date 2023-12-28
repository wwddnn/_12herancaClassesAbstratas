package entities;

// this class extends superclass TaxPayer.
public class Company extends TaxPayer {

    private Integer numberOfEmployee;

    public Company() {
        super();
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployee) {
        super(name, anualIncome);
        this.numberOfEmployee = numberOfEmployee;
    }

    public Integer getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(Integer numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public Double tax() {
        if (numberOfEmployee > 10) {
            return getAnualIncome() * 0.14;
        } else {
            return getAnualIncome() * 0.16;
        }
    }

}
