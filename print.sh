
#!/bin/bash
USER=AlexSH

echo $USER
for run in {1..10}
do
  
  echo $run >>README.md
  
  echo date +"%H:%M:%S" >> README.md
done

