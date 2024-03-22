import React, { useState, useEffect } from 'react';
import { View, Text, SectionList, Image } from 'react-native';
import { SearchBar } from 'react-native-elements';
import axios from 'axios';

const App = () => {
  const [countries, setCountries] = useState([]);
  const [searchText, setSearchText] = useState('');
  const [filteredCountries, setFilteredCountries] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('https://restcountries.com/v3.1/all');
        setCountries(response.data);
        setFilteredCountries(response.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  const updateSearch = (text) => {
    setSearchText(text);
    const filteredResults = countries.filter((country) =>
      country.name.common.toLowerCase().includes(text.toLowerCase()) ||
      (country.currencies && Object.values(country.currencies).some(currency => currency.name.toLowerCase().includes(text.toLowerCase()))) ||
      (country.languages && Object.values(country.languages).some(language => language.toLowerCase().includes(text.toLowerCase())))
    );
    setFilteredCountries(filteredResults);
  };

  const renderSectionHeader = ({ section }) => (
    <Text style={{ fontSize: 18, fontWeight: 'bold', marginBottom: 10 }}>{section.title}</Text>
  );

  const renderItem = ({ item }) => (
    <View style={{ marginBottom: 20 }}>
      <Text style={{ fontSize: 18, fontWeight: 'bold' }}>{item.name.common}</Text>
      <Text>Capital: {item.capital}</Text>
      <Text>Population: {item.population}</Text>
      <Text>Area: {item.area} sq km</Text>
      <Text>Languages: {item.languages && Object.values(item.languages).join(', ')}</Text>
      <Text>Currency: {item.currencies && Object.values(item.currencies).map(currency => currency.name).join(', ')}</Text>
      {item.flags && <Image source={{ uri: item.flags.png }} style={{ width: 50, height: 30, marginTop: 10 }} />}
    </View>
  );

  // Prepare data for SectionList
  const sectionedData = filteredCountries.reduce((acc, country) => {
    const initial = country.name.common.charAt(0).toUpperCase();
    if (!acc[initial]) {
      acc[initial] = [];
    }
    acc[initial].push(country);
    return acc;
  }, {});

  const sections = Object.keys(sectionedData).sort().map(key => ({
    title: key,
    data: sectionedData[key],
  }));

  return (
    <View>
      <SearchBar
        placeholder="Search by country name, currency, or language"
        onChangeText={updateSearch}
        value={searchText}
        platform="ios"
      />
      <Text style={{ fontSize: 20, fontWeight: 'bold', marginBottom: 10 }}>Country List</Text>
      <SectionList
        sections={sections}
        keyExtractor={(item) => item.cca3}
        renderItem={renderItem}
        renderSectionHeader={renderSectionHeader}
      />
    </View>
  );
};

export default App;

