#!/bin/sh

for ((i = 1 ; i <= 10 ; i++)); do
  java -jar virtMem.jar data/test${i}.in > output.txt
  if (diff expectedAnswers/out${i}.in output.txt); then
    echo "PASSED"
  else
    echo "FAILED"
  fi;
  truncate -s 0 output.txt
done

