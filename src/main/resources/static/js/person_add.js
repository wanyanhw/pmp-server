let addPersonUrl = "/person/save";
$().ready(function () {
   $("#submit").click(function () {
       let name = $("input[name='name']").val();
       let account = $("input[name='account']").val();
       let phone = $("input[name='phone']").val();
       let birthday = $("input[name='birthday']").val();
       let sex = $("input[name='sex']").val();
       let age = $("input[name='age']").val();
       let photo = $("input[name='photo']").val();

       let data = {
           name: name,
           account: account,
           phoneNum: phone,
           birthday: birthday,
           sex: sex,
           age: age,
           photo: photo
       };

       console.log(data);
       let saveResult = _post(addPersonUrl, JSON.stringify(data));
       console.log(saveResult);
   });
});