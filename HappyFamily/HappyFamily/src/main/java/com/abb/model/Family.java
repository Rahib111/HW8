package com.abb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Family
{
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family (Human mother, Human father)
    {
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human getMother ()
    {
        return mother;
    }

    public void setMother (Human mother)
    {
        this.mother = mother;
    }

    public Human getFather ()
    {
        return father;
    }

    public void setFather (Human father)
    {
        this.father = father;
    }

    public List<Human> getChildren ()
    {
        return children;
    }

    public void setChildren (List<Human> children)
    {
        this.children = children;
    }

    public Set<Pet> getPet ()
    {
        return pet;
    }

    public void setPet (Set<Pet> pet)
    {
        this.pet = pet;
    }

    public void addChild (Human human)
    {
        children.add(human);
    }

    public void deleteChild (int index)
    {
        if (index >= children.size())
            return;
        children.remove(index);
    }

    public void deleteChild (Human child)
    {
        children.remove(child);
    }

    public int countFamily ()
    {
        return children.size() + 2;
    }

    @Override
    public boolean equals (Object o)
    {
        if (!(o instanceof Family))
            return false;

        Family family = (Family) o;

        if (!family.mother.equals(this.mother))
            return false;
        if (!family.father.equals(this.father))
            return false;
        if (family.children.size() != this.children.size())
            return false;
        for (int i = 0; i < family.children.size(); i++)
        {
            if (!family.children.get(i).equals(this.children.get(i)))
                return false;
        }

        return true;
    }

    @Override
    public String toString ()
    {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children.toString() +
                ", pet=" + pet +
                '}';
    }

    @Override
    protected void finalize () throws Throwable
    {
        System.out.println("Family finalize method was called!");
        super.finalize();
    }
}
