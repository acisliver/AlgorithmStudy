function solution(prices) {
    let answer = 1_000_000;

    for (let i = 0; i < prices.length - 1; i++) {
        for (let j = i + 1; j < prices.length; j++) {
            const loss = prices[i] - prices[j]
            if (loss < 0) continue
            answer = Math.min(answer, loss)
        }
    }

    return answer;
}

console.log(solution([5, 10, 3]))
