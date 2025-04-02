function addContact(
  name,
  mobile,
  home = 'none',
  address = 'none',
  email = 'none'
) {
  let contact = `name=${name}, mobile=${mobile}, home=${home}, address=${address}, email=${email}`;
  console.log(contact);
}

addContact('홍길동', '010-222-3331');
addContact('이몽룡', '010-222-3331', '02-3422-9900', '서울시');
