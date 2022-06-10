const dic = {
    '()': 0, 'O': 0, 'I': 1, 'E': 3, 'A': 4, 'b': 6, 'G': 6, 'T': 7, 'Y': 7, 'E3': 8, 'g': 9, 'q': 9
}


function solution(numstrs, words) {
    const answer = new Array(words.length).fill(0);
    const numbers = [];
    const k = [['2', '5', '3'], ['2', '5', '8'], ['5', '2', '3'], ['5', '2', '8']]

    for (const numstr of numstrs) {

        for (let i = 0; i < k.length; i++) {
            let number = [];
            for (const n of numstr) {
                if (!isNaN(n)) {    // 숫자라면
                    number.push(n);
                } else {            // 문자라면
                    if (n === '_') {
                        number.pop();
                        number.push('2');
                    } else if (n === 'Z') {
                        number.push(k[i][0]);
                    } else if (n === 'S') {
                        number.push(k[i][1]);
                    } else if (n === 'B') {
                        number.push(k[i][2]);
                    } else {
                        number.push(dic[n]);
                    }
                }
            }
            numbers.push(number.join(''));
        }
    }

    let index = 0;
    for (const word of words) {
        for (const num of numbers) {
            if (num.includes(word)) answer[index]++;
        }
        index++;
    }

    return answer;
}

console.log(solution(["ZASSETE", "S4Z537B", "7_ASZEYB"], ["2455373", "425", "373", "378"]));