#!/bin/bash
# start_node.sh
VOTE_PORT=$1
HB_PORT=$2
HB_SIGNAL_PORT=$3

java -jar raft-leader-election-server.jar "$VOTE_PORT" &

python server.py "$HB_PORT" "$HB_SIGNAL_PORT" &

echo "CLIENT: STARTING VOTE (JAVA)"
java -jar raft-leader-election-client.jar

# echo "CLIENT: STARTING HB (PY)"
# python client.py

# maintain container block to avoid container exit
wait