function solution(score) {


    for (let i = 0; i < score.length; i++) {
        score[i].push(i);
    }

    console.log(score)

    let problem1Sum = 0;
    let problem2Sum = 0;

    for (const scoreElement of score) {
        problem1Sum += scoreElement[0];
        problem2Sum += scoreElement[1];
    }

    let difficult;

    if (problem2Sum > problem1Sum) {
        difficult = 1;
    } else if (problem1Sum > problem2Sum) {
        difficult = 2;
    } else {
        difficult = 0;
    }

    console.log(difficult)

    score.sort((a, b) => {
        const diff = a[0] + a[1] - b[0] - b[1];
        if (diff !== 0) return -diff;

        if (difficult === 1) return b[0] - a[0];
        else if (difficult === 2) return b[1] - a[1];
        else return 0;
    })

    const list = score.map(value => value[2]);
    const answer = [];

    for (let i = 0; i < score.length; i++) {
        answer.push(list.indexOf(i) + 1);
    }

    return answer;
}

console.log(solution([[85, 90], [65, 67], [88, 87], [88, 87], [73, 81], [65, 89], [99, 100], [80, 94]]))