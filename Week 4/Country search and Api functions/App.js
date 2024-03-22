import React, { useState, useEffect } from 'react';
import { View, Text, FlatList, Image, TextInput } from 'react-native';
import axios from 'axios';

const App = () => {
  const [countries, setCountries] = useState([]);
  const [searchText, setSearchText] = useState('');

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('https://restcountries.com/v3.1/all');
        setCountries(response.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  const filteredCountries = countries.filter((country) =>
    country.name.common.toLowerCase().includes(searchText.toLowerCase())
  );

  return (
    <View>
      <TextInput
        style={{ height: 40, borderColor: 'gray', borderWidth: 1, marginBottom: 10, paddingLeft: 10 }}
        placeholder="Search by country name"
        onChangeText={(text) => setSearchText(text)}
      />
      <Text style={{ fontSize: 20, fontWeight: 'bold', marginBottom: 10 }}>Country List</Text>
      <FlatList
        data={filteredCountries}
        keyExtractor={(item) => item.cca3}
        renderItem={({ item }) => (
          <View style={{ marginBottom: 20 }}>
            <Text style={{ fontSize: 18, fontWeight: 'bold' }}>{item.name.common}</Text>
            <Text>Capital: {item.capital}</Text>
            <Text>Population: {item.population}</Text>
            <Text>Area: {item.area} sq km</Text>
            <Text>Languages: {item.languages && Object.values(item.languages).join(', ')}</Text>
            <Text>Currency: {item.currencies && item.currencies[Object.keys(item.currencies)[0]].name}</Text>
            {item.flags && <Image source={{ uri: item.flags.png }} style={{ width: 50, height: 30, marginTop: 10 }} />}
          </View>
        )}
      />
    </View>
  );
};

export default App;

