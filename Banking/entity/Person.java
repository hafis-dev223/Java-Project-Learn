package Banking.entity;

public  class Person {

    private String nama;
    private int id;
    private String email;
    private int umur;

    public Person(String nama, int id, String email) {
        this.nama = nama;
        this.id = id;
        this.email = email;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    

}