# Banker's Algorithm 👩‍💻
Banker's Algorithm using MVC Architecture
The user will be able to initialize their own values

## Definition 📄
The Banker's Algorithm is a resource allocation and deadlock avoidance algorithm used in operating systems. It is designed to prevent deadlocks by ensuring that the system's resources are allocated safely to processes.

## BankerAlgorithm 💰🧮🔄
Contains code for Banker's Algorithm

## Model 🤖
Getters and setters

## View 👀
Main menu to initialize values or use preset values

## Controller 🎮
Contains method to preset values and to initialize values

## Main 🏠
Runner and implements Banker's Algorithm to find safe sequence

## Input
Arrays use space-separated values
e.g. "5 4 4 7 6"

## Preset Values
Process: 5
Resource: 3
Max:
7 5 3
3 2 2
9 0 2
2 2 2
4 3 3
Allocation:
0 1 0
2 0 0
3 0 2
2 1 1
0 0 2
Available:
3 3 2