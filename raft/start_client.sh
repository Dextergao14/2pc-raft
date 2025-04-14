#!/bin/bash

echo "CLIENT: STARTING VOTE (JAVA)"
java -jar raft-leader-election-client.jar

echo "CLIENT: STARTING HB (PY)"
python client.py

