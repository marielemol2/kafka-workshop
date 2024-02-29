#!/bin/bash
echo "Creating topic..."
kafka-topics --create --bootstrap-server kafka:9092 --topic tweets
echo "Finished!"