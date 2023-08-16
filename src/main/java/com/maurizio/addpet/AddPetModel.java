/**
 *
 */
package com.maurizio.addpet;

/**
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/gi3hg5pme5-2023-08-16T07:41:06Z/AddPet" target="_top">AWS API
 *      Documentation</a>
 */
public class AddPetModel {

    private Integer age;

    private String name;

    private String ownerName;

    private String species;

    /**
     * @param age
     */

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return
     */

    public Integer getAge() {
        return this.age;
    }

    /**
     * @param age
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AddPetModel age(Integer age) {
        setAge(age);
        return this;
    }

    /**
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */

    public String getName() {
        return this.name;
    }

    /**
     * @param name
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AddPetModel name(String name) {
        setName(name);
        return this;
    }

    /**
     * @param ownerName
     */

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return
     */

    public String getOwnerName() {
        return this.ownerName;
    }

    /**
     * @param ownerName
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AddPetModel ownerName(String ownerName) {
        setOwnerName(ownerName);
        return this;
    }

    /**
     * @param species
     */

    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return
     */

    public String getSpecies() {
        return this.species;
    }

    /**
     * @param species
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AddPetModel species(String species) {
        setSpecies(species);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAge() != null)
            sb.append("Age: ").append(getAge()).append(",");
        if (getName() != null)
            sb.append("Name: ").append(getName()).append(",");
        if (getOwnerName() != null)
            sb.append("OwnerName: ").append(getOwnerName()).append(",");
        if (getSpecies() != null)
            sb.append("Species: ").append(getSpecies());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof AddPetModel == false)
            return false;
        AddPetModel other = (AddPetModel) obj;
        if (other.getAge() == null ^ this.getAge() == null)
            return false;
        if (other.getAge() != null && other.getAge().equals(this.getAge()) == false)
            return false;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false)
            return false;
        if (other.getOwnerName() == null ^ this.getOwnerName() == null)
            return false;
        if (other.getOwnerName() != null && other.getOwnerName().equals(this.getOwnerName()) == false)
            return false;
        if (other.getSpecies() == null ^ this.getSpecies() == null)
            return false;
        if (other.getSpecies() != null && other.getSpecies().equals(this.getSpecies()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getAge() == null) ? 0 : getAge().hashCode());
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode());
        hashCode = prime * hashCode + ((getOwnerName() == null) ? 0 : getOwnerName().hashCode());
        hashCode = prime * hashCode + ((getSpecies() == null) ? 0 : getSpecies().hashCode());
        return hashCode;
    }
}
