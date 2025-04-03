let likePizza = false;
const orderPizza = new Promise((resolve, reject) => {
  if (likePizza) {
    resolve('피자를 주문했습니다.');
  } else reject('피자를 주문하지 않았습니다.');
});

orderPizza
  .then((orderMsg) => console.log(orderMsg))
  .catch((error) => console.error(error));
