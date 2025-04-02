let msg = 'GLOBAL';
function outer() {
  console.log(msg);
  if (true) {
    let msg = 'BLOCK';
    console.log(msg);
  }
}

outer();
//GLOBAL
//BLOCK
