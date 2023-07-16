package ApiSteps;

public enum ApiValues {
    MainPerson("Kyrylo", "Shmana", "2023-01-02", "2023-01-03", 12345, true, "burger"),
    SecondaryPerson("Jony", "Depp", "2023-02-02", "2023-02-03", 1234543, false, "Pizza");
    private final String firstname;
    private final String lastname;
    private final String checkin;
    private final String checkout;
    private final int totalprice;
    private final boolean deposidpaid;
    private final String additionalneeds;

    ApiValues(String firstname, String lastname, String checkin, String checkout, int totalprice, boolean deposidpaid, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.checkin = checkin;
        this.checkout = checkout;
        this.totalprice = totalprice;
        this.deposidpaid = deposidpaid;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public boolean isDeposidpaid() {
        return deposidpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

}
