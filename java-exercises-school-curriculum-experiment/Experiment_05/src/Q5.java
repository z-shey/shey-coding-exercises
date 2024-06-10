import org.junit.Test;

/************************ Human Interface Begin ************************/
interface Human {
    public abstract void createHuman();
}
/************************ Human Interface End ************************/

/************************ SimpleFactory Begin ************************/
class Man implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created man!");
    }
}

class Woman implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created woman!");
    }
}

class SimpleFactory {
    public Human create(String type) {
        return type.equals("Woman") ? new Woman() : new Man();
    }
}
/************************ SimpleFactory End ************************/

/************************ MethodFactory Begin ************************/
interface MethodFactory {
    public abstract Human humanCreate();
}

class ManFactory implements MethodFactory {
    @Override
    public Human humanCreate() {
        return new Man();
    }
}

class WomanFactory implements MethodFactory {

    @Override
    public Human humanCreate() {
        return new Woman();
    }
}
/************************ MethodFactory End ************************/

/************************ AbstractFactory Begin ************************/
interface AbstractFactory {
    public abstract Human createMan();

    public abstract Human createWoman();
}

class WhiteMan implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created White man");
    }
}

class WhiteWoman implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created White woman");
    }
}

class WhiteFactory implements AbstractFactory {
    @Override
    public Human createMan() {
        return new WhiteMan();
    }

    @Override
    public Human createWoman() {
        return new WhiteWoman();
    }
}

class YellowMan implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created Yellow man");
    }
}

class YellowWoman implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created Yellow woman");
    }
}

class YellowFactory implements AbstractFactory {
    @Override
    public Human createMan() {
        return new YellowMan();
    }

    @Override
    public Human createWoman() {
        return new YellowWoman();
    }
}

class BlackMan implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created Black man");
    }
}

class BlackWoman implements Human {
    @Override
    public void createHuman() {
        System.out.println("Nuwa created Black woman");
    }
}

class BlackFactory implements AbstractFactory {
    @Override
    public Human createMan() {
        return new BlackMan();
    }

    @Override
    public Human createWoman() {
        return new BlackWoman();
    }
}
/************************ AbstractFactory End ************************/

/************************ Unit Test Begin ************************/
public class Q5 {
    public static final String Man = "Man";
    public static final String Woman = "Woman";

    @Test
    public void Q5SimpleFactoryTest() {
        SimpleFactory simpleFactory = new SimpleFactory();
        simpleFactory.create(Man).createHuman();
        simpleFactory.create(Woman).createHuman();
    }

    @Test
    public void Q5MethodFactoryTest() {
        ManFactory manFactory = new ManFactory();
        Human man = manFactory.humanCreate();
        man.createHuman();

        WomanFactory womanFactory = new WomanFactory();
        Human woman = womanFactory.humanCreate();
        woman.createHuman();
    }

    @Test
    public void Q5AbstractFactoryTest() {
        AbstractFactory factory1 = new WhiteFactory();
        Human whiteMan = factory1.createMan();
        Human whiteWoman = factory1.createWoman();
        whiteMan.createHuman();
        whiteWoman.createHuman();

        AbstractFactory factory2 = new YellowFactory();
        Human yellowMan = factory2.createMan();
        Human yellowWoman = factory2.createWoman();
        yellowMan.createHuman();
        yellowWoman.createHuman();

        AbstractFactory factory3 = new BlackFactory();
        Human blackMan = factory3.createMan();
        Human blackWoman = factory3.createWoman();
        blackMan.createHuman();
        blackWoman.createHuman();
    }
}
/************************ Unit Test End ************************/