#!/bin/bash

echo "COORD: STARTING VOTING PHASE (PY)"
python phase_1_client_coordinator.py

echo "COORD: STARTING DECISION PHASE (JAVA)"
java -jar twopc-decision-phase-client.jar