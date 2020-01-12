
// 循环
//for(var i = 0;i<10;i++){
//    console.info(i)
//}
//console.info("外层循环："+i);
/**
for(let i = 0;i<10;i++){
    console.info(i)
}
console.info("外层循环："+i);
 **/

/**
const a =1;
console.log("a = ",a);

// 给a赋值
a = 2;
console.log("a = " ,a);
 **/

/**
let str = "hello heima";
console.log(str, " 中是否包含了heima => ", str.includes("heima"));
console.log(str, " 中是否包含了baima => ", str.includes("baima"));
console.log(str, " 中是否以h开头 => ", str.startsWith("h"));
console.log(str, " 中是否以a开头 => ", str.startsWith("a"));
console.log(str, " 中是否以a结束 => ", str.endsWith("a"));
console.log(str, " 中是否以h结束 => ", str.endsWith("h"));
 **/

/**
let str = `
hello 
itheima
itcast
`;
console.log(str);
 **/
/**
let arr = [1,2,3]
const [x,y,z] = arr;// x，y，z将与arr中的每个位置对应来取值
// 然后打印
console.log(x,y,z);
const [a] = arr; //只匹配1个参数
console.log(a);
 **/

/**
const person = {
    name:"jack",
    age:21,
    language: ['java','js','css']
}

console.log(person.age)



//  解构表达式获取值
const {name,age,language} = person;
// 打印
 console.log(name);
 console.log(age);
 console.log(language);



function add(a,b){
    b = b || 1;
    return a+b;
}


function add(a,b=1){
    return a + b;
}
console.log(add(10))


var print = function(obj){
    console.log(obj);
}

print('aaaaa');

var print2 = obj => console.log(obj);

print2('bbbb');


var sum = function(a,b){
    return a+b;
}

console.info(sum(1,2));

var sum2 = (a,b) => a+b;

console.info(sum(1,2));

var sum3 = (a,b) =>{
    console.info('多行信息');
    return a+b;
}

console.info(sum(1,2));


let sayHelko =()=>console.log("hello!");

sayHelko();
 **/

//对象的函数属性简写
/**
let person = {
    name:"bruce",
    eat:function(food){
        console.log(this.name +"再吃：" + food);
    },
    eat2:food=> console.log(person.name +"再吃：" + food), //这里拿不到this
    eat3(food){
        console.log(this.name +"再吃：" + food);
    }
}

person.eat("米饭");
person.eat2("米饭2");
person.eat3("米饭3");


const person = {
    name:"mrduan",
    age:21,
    language:['java','js','css']
}

function hello(person){
    console.log(person.name);
}

hello(person);

var hi = ({name}) =>  console.log("hello," + name);
hi(person)
 **/

// 1.5、map和reduce
/**
let arr = ['1','20','-5','3'];
console.log(arr);
let newArr = arr.map(s => parseInt(s));
console.log(newArr);
**/

/**
const arr = [1,20,-5,3];

console.log(arr.reduce((a,b)=>a+b))
 **/

//1.6 、扩展运算符
/**
console.log (...[1, 2, 3]); //1 2 3
console.log(1, ...[2, 3, 4], 5); // 1 2 3 4 5

function add(x, y) {
    return x + y;
}
var numbers = [1, 2];
console.log(add(...numbers)); // 3

// 数组合并
let arr = [...[1,2,3],...[4,5,6]];
console.log(arr); //[1, 2, 3, 4, 5, 6]
// 与解构表达式结合
const [first, ...rest] = [1, 2, 3, 4, 5];
console.log(first, rest) //1  [2, 3, 4, 5]


console.log([...'hello']) //["h", "e", "l", "l", "o
**/


// Promise
    /**
const p = new Promise(function (resolve, reject) {
    // 这里我们用定时任务模拟异步
    setTimeout(() => {
        const num = Math.random();
        // 随机返回成功或失败
        if (num < 0.5) {
            resolve("成功！num:" + num)
        } else {
            reject("出错了！num:" + num)
        }
    }, 300)
})

// 调用promise
p.then(function (msg) {
    console.log(msg);
}).catch(function (msg) {
    console.log(msg);
})
     **/

// Set 构造函数可以接收一个数组或空
/**
let set = new Set();
set.add(1);// [1]
// 接收数组
let set2 = new Set([2,3,4,5,5]);// 得到[2,3,4,5]
set.add(1);//  添加
set.clear();// 清空
set.delete(2);// 删除指定元素
set.has(2); // 判断是否存在
set.forEach(function(){console.info("aaa")})//遍历元素
set.size; // 元素个数。是属性，不是方法。



// map 接收一个数组，数组中的元素是键值对数组
const map = new Map([
    ['key1','value1'],
    ['key2','value2'],
])
// 或者接收一个set
const set = new Set([
    ['key1','value1'],
    ['key2','value2'],
])
const map2 = new Map(set)
// 或者其它map
const map3 = new Map(map);


map.set(key, value);// 添加
map.clear();// 清空
map.delete(key);// 删除指定元素
map.has(key); // 判断是否存在
map.forEach(function(key,value){})//遍历元素
map.size; // 元素个数。是属性，不是方法
map.values() //获取value的迭代器
map.keys() //获取key的迭代器
map.entries() //获取entry的迭代器
//用法：
for (let key of map.keys()) {
    console.log(key);
}

console.log(...map.values()); //通过扩展运算符进行展开
 **/

// class
/**
class User {
    constructor(name ,age = 20){
        this.name = name;
        this.age = age;
    }

    sysHello(){
        return "hello";
    }

    static isAdult(age){
        if(age>=18){
            return "成年";
        }
        return "未成年";
    }
}

let user = new User("张三");
// 测试
console.log(user); // User {name: "张三", age: 20}
console.log(user.sysHello()); // hello
console.log(User.isAdult(15)); // 成年人


class Zhangsan extends User {
    constructor(){
        super("张三",30);
        this.address = "上海";
    }
}
// 测试
let zs = new Zhangsan();
console.log(zs.name, zs.address);
console.log(zs.sysHello());
console.log(Zhangsan.isAdult(20))
**/

/**
function* hello () {
    yield "hello";
    yield "world";
    return "done";
}
let h = hello();

//console.log(h.next()); //{value: "hello", done: false}
//console.log(h.next()); //{value: "world", done: false}
//console.log(h.next()); //{value: "done", done: true}
//console.log(h.next()); //{value: undefined, done: true}
for (let obj of h) {
    console.log(obj);
}
 **/

@T //通过@符号进行引用该方法，类似java中的注解
class User {
    constructor(name, age = 20){
        this.name = name;
        this.age = age;
    }
}

function T(target) { //定义一个普通的方法
    console.log(target); //target对象为修饰的目标对象，这里是User对象
    target.country = "中国"; //为User类添加一个静态属性country
}
console.log(User.country); //打印出country属性值
