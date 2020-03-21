#!/bin/sh

PID=$(ps -ef | grep "thymeleaf" | grep -v grep | awk '{print $2}')
if [[ "" != "$PID" ]]; then
  echo "killing $PID"
  kill -9 $PID

  sleep 3
fi

java -Dspring.config.location=application.properties -jar thymeleaf-1.0-SNAPSHOT.jar >> log/console.log &
