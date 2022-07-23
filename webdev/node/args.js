console.log("hello from args");
console.log(process.argv); // print the args as an array. node args.js 'yes' 'no'

names = process.argv.slice(2);

for (let arg of names){
    console.log(`Hi there, ${arg}!`);
}