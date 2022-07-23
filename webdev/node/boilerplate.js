const { deepStrictEqual } = require('assert');
const fs = require('fs');
const dirName = process.argv[2] || 'Project';
console.log(dirName);

try {
    fs.mkdirSync(dirName);
    onsole.log(typeof `${dirName}/index.html`);
    fs.writeFileSync(`${dirName}/index.html`,'')
} catch (e){
    console.log("Something went wrong");
    console.log(e);
}


