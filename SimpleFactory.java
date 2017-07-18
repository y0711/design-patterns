public class SimpleFactory
{
  public static void main(String[] args)
  {
    Fruit f1 = FruitFactory.getFruit(0);
    Fruit f2 = FruitFactory.getFruit(1);
    
    System.out.println("f1: " + f1.getInfo());
    System.out.println("f2: " + f2.getInfo());
  }
}

abstract class Fruit {
  String getInfo() {
    return "name is: " + getName();
  }
  abstract String getName();
}

class Apple extends Fruit {
  String getName() {
    return "apple";
  }
}

class Orange extends Fruit {
  String getName() {
    return "orange";
  }
}

class FruitFactory {
  public static Fruit getFruit(int option) {
    if (option == 0) {
      return new Apple();
    }
    return new Orange();
  }
}
