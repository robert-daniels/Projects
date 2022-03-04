'''Data Cleaning Assignment
Author: Robert D.
01/21/2022'''

import pandas as pd

# read in the data set
df = pd.read_csv("RawDataForAssignment.csv")

# get some initial impressions
print(df.dtypes)
print(df['gender'].value_counts())
print(df.describe())

# drop extraneous data
df = df.drop(['email'], axis=1)

# drop rows with null birthday_month (fill.mean makes no sense here)
df = df.dropna(subset=['birthday_month'])

'''Remove null age. Not willing to backfill ~11% of dataset with the mean.'''
df = df.dropna(subset=['age'])

# apply mask to filter nonsensical ages. 122 is world record
df = df[(df.age >= 0) & (df.age <= 122)]

# apply mask to birthday_month
df = df[(df.birthday_month >= 1) & (df.birthday_month <= 12)]

#convert column type
df = df.astype({'birthday_month' : 'int32'})

# clean gender. could also regex if contains ['f','F']
df['gender'] = df['gender'].str.strip()
df['gender'] = df['gender'].replace(['M','m','male'],'Male')
df['gender'] = df['gender'].replace(['F','F ''f','f ','female'],"Female")

# export clean data to csv
df.to_csv('scrubbed_data.csv')
