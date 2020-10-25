#!/bin/sh
kotlinc src/CommonAlgorithm.kt src/InputParser.kt src/ReplacementPosition.kt src/VirtMem.kt src/VirtualMemory.kt -include-runtime -d virtMem.jar
for ((i = 1 ; i <= 10 ; i++)); do
  java -jar virtMem.jar data/test${i}.in > output.txt
  if (diff expectedAnswers/out${i}.in output.txt); then
    echo "PASSED"
  else
    echo "FAILED"
  fi;
  truncate -s 0 output.txt
done

