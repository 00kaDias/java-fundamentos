package entities;

public class Student {
    private int codUni;

    public Student(int codUni) {
        this.codUni = codUni;
    }

    public int getCodUni() {
        return codUni;
    }

    public void setCodUni(int codUni) {
        this.codUni = codUni;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codUni;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (codUni != other.codUni)
            return false;
        return true;
    }
}
