const d1 = new Date(); // 서버 시간을 기준으로, 클라이언트 기준X
let name = '홍길동';
let r1 = `${name} 님에게 ${d1}에 연락했다.`;

let product = '갤럭시S7';
let price = 199000;
let str = `${product}의 가격은
        ${price}원 입니다.`;
console.log(r1);
console.log(str);
