import React, { useEffect, useState } from 'react';
import axios from 'axios';
import RestaurantForm from './RestaurantForm';

function Dashboard() {
  const [restaurants, setRestaurants] = useState([]);
  const [editing, setEditing] = useState(null);

  const fetchRestaurants = async () => {
    const res = await axios.get('/api/restaurants');
    setRestaurants(res.data);
  };

  useEffect(() => {
    fetchRestaurants();
  }, []);

  const handleAdd = async (data) => {
    await axios.post('/api/restaurants', data);
    fetchRestaurants();
  };

  const handleEdit = async (id, data) => {
    await axios.put(`/api/restaurants/${id}`, data);
    setEditing(null);
    fetchRestaurants();
  };

  const handleDelete = async (id) => {
    await axios.delete(`/api/restaurants/${id}`);
    fetchRestaurants();
  };

  return (
    <div>
      <h2>Restaurants</h2>
      <RestaurantForm onSubmit={handleAdd} />
      <table border="1">
        <thead>
          <tr>
            <th>Name</th>
            <th>Location</th>
            <th>Type</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {restaurants.map(r => (
            <tr key={r.id}>
              <td>{r.name}</td>
              <td>{r.location}</td>
              <td>{r.type}</td>
              <td>
                <button onClick={() => setEditing(r)}>Edit</button>
                <button onClick={() => handleDelete(r.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {editing && (
        <RestaurantForm initial={editing} onSubmit={data => handleEdit(editing.id, data)} />
      )}
    </div>
  );
}

export default Dashboard;
