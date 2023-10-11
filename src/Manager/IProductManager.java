package Manager;

import java.util.List;

public interface IProductManager<E> {
    public void add(E e);

    public int findIndexById(int id);

    public void edit(int id, E e);

    public void delete(int id);

    public List<E> showAll();

    public void sortIncreaseProduct();

    public void sortDecreaseProduct();

    public void searchProductMaxPrice();

}
