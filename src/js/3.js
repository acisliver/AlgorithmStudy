function solution(sentence, word) {
    return sentence ? sentence.split(" ").indexOf(word) : -1
}

console.log(solution("Hello every world", "every"))