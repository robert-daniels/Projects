#working with dictionaries, a built in class

#create a mapping of state to abbrev

states = {
    'Oregon': 'OR',
    'Florida': 'FL',
    'California': 'CA',
    'New York': 'NY',
    'Michigan': 'MI'
}

#dictionaries of state to city

cities = {
    'CA': 'San Francisco',
    'MI': 'Detroit',
    'FL': 'Jacksonville'
}

#add more cities

cities['NY'] = 'New York'
cities['OR'] = 'Portland'

print("-" * 10)
print("NY State has: ", cities['NY'])
print("OR State has: ", cities['OR'])
print("MI State has: ", cities['MI'])

print('-' * 10)
print("Michigan's abbrev is: ", states['Michigan'])
print("Florida's abbrev is: ", states['Florida'])

#nest them in

print("-" * 10)
print("Michigan has: ", cities[states['Michigan']])
print("Florida has: ", cities[states['Florida']])


print("-" * 10)

#for loop given two variables. dictionary made into a list object with items method call

for state, abbrev in list(states.items()):
    print(f"{state} has the abbreviation {abbrev}")

#for loop 2 variables, same.

for abbrev, city in list(cities.items()):
    print(f"{abbrev} has the city {city}.")


#both at the same time

print('-' * 10)

for state, abbrev in list(states.items()):
    print(f"{state} state is abbreviated {abbrev}")
    print(f"and has city {cities[abbrev]}")

print('-' * 10)

input_state = input("Pick a US State: ")

state = states.get(input_state)

if not state:
    print(f"Sorry, {input_state} is not in my dictionary")

city = cities.get('TX', 'Does not exist')
print(f"the city for the state 'TX' is: {city}")
