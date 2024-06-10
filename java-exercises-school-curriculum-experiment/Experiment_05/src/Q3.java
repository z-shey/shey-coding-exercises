import org.junit.Test;

class InnerShoppingVoucher {
    private double value; // 代金券余额

    public InnerShoppingVoucher(double value) { // 构造方法
        this.value = value;
    }

    public double getValue() { // 获得代金券金额
        return value;
    }

    public void buyGoods(Goods goods) {
        if (getValue() > goods.getPrice()) { // 检查代金券余额是否足够购买商品
            value -= goods.getPrice(); // 更新代金券余额
            System.out.println("Buy " + goods.getName() + ", Use " + goods.getPrice() + " Remaining: " + getValue()); // 打印购买信息
        } else {
            System.out.println("Not buy something! " + goods.getPrice() + " is more than " + getValue()); // 打印余额不足的信息
        }
    }
}

class Goods {
    private String name; // 商品名称
    private double price; // 商品价格

    public Goods(String name, double price) { // 构造方法
        this.name = name;
        this.price = price;
    }

    public String getName() { // 获得商品名称
        return name;
    }

    public double getPrice() { // 获得商品价格
        return price;
    }
}


class SupermarketShop {
    private InnerShoppingVoucher voucher1000; // 1000元代金券
    private InnerShoppingVoucher voucher2000; // 2000元代金券
    private Goods[] goodsList; // 商品列表

    public SupermarketShop() {
        voucher1000 = new InnerShoppingVoucher(1000); // 初始化1000元代金券
        voucher2000 = new InnerShoppingVoucher(2000); // 初始化2000元代金券

        goodsList = new Goods[]{ // 初始化商品列表
                new Goods("Product 1", 500),
                new Goods("Product 2", 800),
                new Goods("Product 3", 1500),
                new Goods("Product 4", 200)
        };
    }

    public Goods[] getGoodsList() { // 获得商品列表
        return goodsList;
    }

    public InnerShoppingVoucher getVoucher1000() { // 获得1000元代金券
        return voucher1000;
    }

    public InnerShoppingVoucher getVoucher2000() { // 获得2000元代金券
        return voucher2000;
    }
}

public class Q3 {
    @Test
    public void Q3Test() {
        SupermarketShop supermarketShop = new SupermarketShop(); // 创建超市对象
        Goods[] goodsList = supermarketShop.getGoodsList(); // 获取商品列表

        supermarketShop.getVoucher1000().buyGoods(goodsList[0]); // 使用1000元代金券购买商品1
        supermarketShop.getVoucher1000().buyGoods(goodsList[1]); // 使用1000元代金券购买商品2

        supermarketShop.getVoucher2000().buyGoods(goodsList[0]); // 使用2000元代金券购买商品1
        supermarketShop.getVoucher2000().buyGoods(goodsList[1]); // 使用2000元代金券购买商品2
        supermarketShop.getVoucher2000().buyGoods(goodsList[2]); // 使用2000元代金券购买商品3
    }
}
