package com.rd.person;

public class Man extends  Person {

    public Man(String firstName, String lastName, int age, Person partner, String previousLastName, boolean isRegisterPartnership, boolean isPartnerChanged) {
        super(firstName, lastName, age, partner, previousLastName, isRegisterPartnership, isPartnerChanged);
    }

    public Man(boolean isRegisterPartnership) {
        super(isRegisterPartnership);
    }

    @Override
    public boolean isRetired() {

        return (Man.super.getAge() > 65 );
    }

    @Override
    public void registerPartnership(Person partner) {
        if (Man.this.isRegisterPartnership){

            System.out.println("You are married");
        }

        else  {
            setPartner(partner);
            setRegisterPartnership(true);
            partner.setPartner(this);
            setPartnerChanged(true);

        }

    }

    @Override
    public void deregisterPartnership (boolean isRegisterPartnership){
        if (isRegisterPartnership) {
            setPartner(null);
            setRegisterPartnership(false);

        }


    }


}
