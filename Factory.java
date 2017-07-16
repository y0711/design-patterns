// one class needs to have a main() method
public class Factory
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    // TODO: Use reflection and config file to create concrete factory.
    FruitFactory factory = new AppleFactory();
    Fruit fruit = factory.getFruit();
    
    System.out.println("fruit: " + fruit.getInfo());
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

interface FruitFactory {
  Fruit getFruit();
}

class AppleFactory implements FruitFactory {
  public Fruit getFruit() {
    return new Apple();
  }
}

class OrangeFactory implements FruitFactory {
  public Fruit getFruit() {
    return new Orange();
  }
}
