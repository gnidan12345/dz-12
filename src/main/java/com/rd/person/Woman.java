package com.rd.person;

public class Woman extends Person{

    public Woman(String firstName, String lastName, int age, Person partner, String previousLastName, boolean isRegisterPartnership, boolean isPartnerChanged) {
        super(firstName, lastName, age, partner, previousLastName, isRegisterPartnership, isPartnerChanged );
    }

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public Woman(boolean isRegisterPartnership) {
        super(isRegisterPartnership);
    }

    @Override
    public boolean isRetired() {

        return (Woman.super.getAge() > 60 );
    }


    @Override
    public void registerPartnership(Person partner) {

        if (Woman.super.isRegisterPartnership == true){

            System.out.println("You are married");
        } else if (partner instanceof Man){
            setPartner(partner);
            setPreviousLastName(getLastName());
            setLastName(partner.getLastName());
            setRegisterPartnership(true);
            partner.setRegisterPartnership(true);
            partner.setPartner(this);
            setPartnerChanged(true);

        }

    }

    @Override
    public void deregisterPartnership(boolean isRegisterPartnership) {
        {
            if (isRegisterPartnership) {

                setLastName(getPreviousLastName());
                setPartner(null);



            }
        }


    }




}
